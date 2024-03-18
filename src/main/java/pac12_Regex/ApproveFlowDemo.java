package pac12_Regex;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Frank.Tang
 * @date 2022-07-22 22:46
 * @desc
 **/
public class ApproveFlowDemo {

    private static final String nodeRegex = "([&|])(\\d+,?)+([&|])";
    private static final String nodePassRegex = "([&|])(\\d+,?)+([&|])p";

    private static final String OR = "|";
    private static final String AND = "&";

    private static final String USER_SP = ",";
    private static final String NODE_SP = " > ";

    private static final String PASS = "p";
    private static final String REJECT = "r";

    private static final String COUNTER_SIGN_PASS_TAG = AND + PASS;
    private static final String OR_SIGN_PASS_TAG = OR + PASS;
    private static final String COUNTER_SIGN_REJECT_TAG = AND + REJECT;
    private static final String OR_SIGN_PASS_REJECT_TAG = OR + REJECT;

    private static final String OR_AND_REGEX = "[&|]";

    private static final String ALL_PASSED = "all_passed";
    private static final String REJECTED = "rejected";
    private static final String USER_APPROVED = "user_approved";
    private static final String CAN_NOT_APPROVE = "can_not_approve";


    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                demo1();
            }).start();
        }
    }

    private static void demo1() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());

            long sTime = System.currentTimeMillis();

            //String flow = "&1,2,3& > |4,5| > &2,4& > &3&";
            //String flow = "&1p&p > &2p&p > &3&";
            //String flow = "&1p,2p&p > |1,2,3,4p|p > |4,5p|p > &2,3&";
            String flow = "&1&";
            //String flow = "&1p,2,3p&";
            //String flow = "|1,2|";
            //String flow = "&1p&p > &2p&p > &3p&p";

            System.out.println("原审批流: " + flow);
            System.out.println("原审批流进度: " + getRateOfProgress(flow) + "\n");

            String res = approve(flow, 1L, true);
            if (ALL_PASSED.equals(res)) {
                throw new RuntimeException("审批流已全部通过");
            } else if (REJECTED.equals(res)) {
                throw new RuntimeException("审批流已驳回");
            } else if (CAN_NOT_APPROVE.equals(res)) {
                throw new RuntimeException("这个用户不能审批当前节点");
            } else if (USER_APPROVED.equals(res)) {
                throw new RuntimeException("这个用户已审批过当前节点");
            }

            System.out.println("审批结果: " + res);
            System.out.println("审批流已通过: " + allPassed(res));
            System.out.println("审批流已驳回: " + isRejected(res));
            System.out.println("审批流进度: " + getRateOfProgress(res));
            System.out.println();

            long eTime = System.currentTimeMillis();
            System.out.println("耗时: " + (eTime - sTime) + "ms");
        }
    }


    /**
     * 执行审批
     * @author Frank.Tang
     * @param flow 审批流
     * @param approvalUser 审批人id
     * @param passOrReject true --> 通过 / false --> 驳回
     * @return all_passed 审批流已完全通过
     *         can_not_approve 当前用户不能审批
     *         rejected 审批流已被驳回
     *         flow 审批成功
     */
    private static String approve(String flow, Long approvalUser, boolean passOrReject) {
        return approve(flow, approvalUser.toString(), passOrReject);
    }

    /**
     * 执行审批
     * @author Frank.Tang
     * @param flow 审批流
     * @param approvalUser 审批人id
     * @param passOrReject true --> 通过 / false --> 驳回
     * @return rejected 审批流已被驳回
     *         all_passed 审批流已完全通过
     *         can_not_approve 当前用户不能审批
     *         flow 审批成功
     */
    private static String approve(String flow, String approvalUser, boolean passOrReject) {
        String[] nodeArr = flow.split(NODE_SP);

        //审批流已通过
        if (allPassed(flow)) {
            return ALL_PASSED;
        }

        //审批流已驳回
        if (isRejected(flow)) {
            return REJECTED;
        }

        //拿当前审批节点
        String currentApproveNode = getCurrentApproveNode(flow);

        //通过
        if (passOrReject) {
            return pass(nodeArr, currentApproveNode, approvalUser);
        }
        //驳回
        else {
            return reject(nodeArr, currentApproveNode, approvalUser);
        }
    }

    /**
     * 通过
     * @author Frank.Tang
     * @return *
     */
    private static String pass(String[] nodeArr, String currentApproveNode, String approvalUser) {
        //处理后的节点列表
        List<String> newNodeList = new ArrayList<>();
        //找到审批人
        boolean findTargetUser = false;
        //目标节点已审批(防止连续的同人节点连审)
        boolean currentNodeApproved = false;

        for (String node : nodeArr) {
            //非当前审批节点, 跳过
            if (!currentApproveNode.equals(node)) {
                newNodeList.add(node);
                continue;
            }
            //true --> 与签 / false --> 或签
            boolean counterSign = node.startsWith(AND);
            //节点用户
            String[] userArr = node.split(USER_SP);

            ///////////////////////////////////////与签///////////////////////////////////////
            List<String> nodeUserList = new ArrayList<>();
            if (counterSign) {
                int passCount = 0;
                for (String tempUser : userArr) {
                    //去掉节点首尾的 "与/或"
                    tempUser = tempUser.replaceAll(OR_AND_REGEX, "");

                    //这个人已通过
                    if (tempUser.endsWith(PASS)) {
                        //目标用户已经审批了
                        if (tempUser.equals(approvalUser + PASS)) {
                            return USER_APPROVED;
                        }
                        nodeUserList.add(tempUser);
                        passCount++;
                        continue;
                    }
                    //找到这个审批人
                    if (!findTargetUser && approvalUser.equals(tempUser)) {
                        nodeUserList.add(tempUser + PASS);
                        findTargetUser = true;
                        passCount++;
                    }
                    //没找到这个审批人
                    else {
                        nodeUserList.add(tempUser);
                    }
                }

                //这个节点内, 没找到审批人
                if (!findTargetUser) {
                    return CAN_NOT_APPROVE;
                }
                //拼接用户id
                else {
                    node = StringUtils.join(nodeUserList, USER_SP);
                }

                //当前节点内, 所有人已通过
                if (passCount == userArr.length) {
                    node = AND + node + AND + PASS;
                }
                //这个节点还需要审
                else {
                    node = AND + node + AND;
                }
            }
            ///////////////////////////////////////或签///////////////////////////////////////
            else {
                for (String tempUser : userArr) {
                    //去掉节点首尾的 "与/或"
                    tempUser = tempUser.replaceAll(OR_AND_REGEX, "");

                    //这个人已通过
                    if (tempUser.endsWith(PASS)) {
                        nodeUserList.add(tempUser);
                        continue;
                    }
                    //找到当前审批人
                    if (!findTargetUser && approvalUser.equals(tempUser)) {
                        nodeUserList.add(tempUser + PASS);
                        findTargetUser = true;
                    } else {
                        nodeUserList.add(tempUser);
                    }
                }
                //这个节点内, 没找到审批人
                if (!findTargetUser) {
                    return CAN_NOT_APPROVE;
                }
                //审批直接过
                else {
                    node = currentNodeApproved ?
                            OR + StringUtils.join(nodeUserList, USER_SP) + OR :
                            OR + StringUtils.join(nodeUserList, USER_SP) + OR + PASS;
                    currentNodeApproved = true;
                }
            }
            newNodeList.add(node);
        }
        return StringUtils.join(newNodeList, NODE_SP);
    }

    /**
     * 驳回
     * @author Frank.Tang
     * @return *
     */
    private static String reject(String[] nodeArr, String currentApproveNode, String approvalUser) {
        List<String> newNodeList = new ArrayList<>();
        //找到审批人
        boolean findTargetUser = false;
        //目标节点已审批(防止连续的同人节点连审)
        boolean currentNodeApproved = false;

        for (String node : nodeArr) {
            //非当前审批节点, 跳过
            if (!currentApproveNode.equals(node)) {
                newNodeList.add(node);
                continue;
            }
            //true --> 与签 / false --> 或签
            boolean counterSign = node.startsWith(AND);
            //节点用户
            String[] userArr = node.split(USER_SP);

            List<String> nodeUserList = new ArrayList<>();
            for (String tempUser : userArr) {
                //去掉节点首尾的 "与/或"
                tempUser = tempUser.replaceAll(OR_AND_REGEX, "");

                //目标用户已经审批了
                if (tempUser.equals(approvalUser + PASS)) {
                    return USER_APPROVED;
                }

                //找到这个审批人
                if (!findTargetUser && approvalUser.equals(tempUser)) {
                    nodeUserList.add(tempUser + REJECT);
                    findTargetUser = true;
                }
                //没找到这个审批人
                else {
                    nodeUserList.add(tempUser);
                }
            }

            //这个节点内, 没找到审批人
            if (!findTargetUser) {
                return CAN_NOT_APPROVE;
            }
            //找到目标审批人, 整个节点记为驳回
            else {
                if (!currentNodeApproved) {
                    node = (counterSign ? AND : OR) +
                            StringUtils.join(nodeUserList, USER_SP) +
                            (counterSign ? AND : OR) +
                            REJECT;
                    currentNodeApproved = true;
                }
            }
            newNodeList.add(node);
        }
        return StringUtils.join(newNodeList, NODE_SP);
    }


    /**
     * 拿到审批流当前需要审批的节点
     * @author Frank.Tang
     * @return *
     */
    private static String getCurrentApproveNode(String flow) {
        String[] nodeArr = flow.split(NODE_SP);
        for (String node : nodeArr) {
            if (!node.endsWith(COUNTER_SIGN_PASS_TAG) && !node.endsWith(OR_SIGN_PASS_TAG)) {
                return node;
            }
        }
        return "";
    }

    /**
     * 审批流是否已驳回
     * @author Frank.Tang
     * @param flow 审批流
     * @return true ---> 审批流已驳回
     *         false --> 审批流未驳回
     */
    private static boolean isRejected(String flow) {
        String[] nodeArr = flow.split(NODE_SP);
        for (String node : nodeArr) {
            if (node.endsWith(COUNTER_SIGN_REJECT_TAG) || node.endsWith(OR_SIGN_PASS_REJECT_TAG)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断节点是否全通过
     * @author Frank.Tang
     * @param flow 审批流
     * @return true ---> 审批流已全部通过
     *         false --> 审批流还没通过
     */
    private static boolean allPassed(String flow) {
        String[] nodeArr = flow.split(NODE_SP);
        for (String node : nodeArr) {
            if (!node.endsWith(COUNTER_SIGN_PASS_TAG) && !node.endsWith(OR_SIGN_PASS_TAG)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 获取审批流进度
     * @author Frank.Tang
     * @param flow 审批流
     * @return 已审节点数/总结点数
     */
    private static String getRateOfProgress(String flow) {
        int passCount = 0;
        String[] nodeArr = flow.split(NODE_SP);
        for (String node : nodeArr) {
            if (node.endsWith(COUNTER_SIGN_PASS_TAG) || node.endsWith(OR_SIGN_PASS_TAG) ||
                    node.endsWith(COUNTER_SIGN_REJECT_TAG) || node.endsWith(OR_SIGN_PASS_REJECT_TAG)) {
                passCount++;
            }
        }
        return passCount + "/" + nodeArr.length;
    }

}
