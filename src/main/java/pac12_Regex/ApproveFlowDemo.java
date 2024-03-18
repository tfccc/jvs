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

            System.out.println("ԭ������: " + flow);
            System.out.println("ԭ����������: " + getRateOfProgress(flow) + "\n");

            String res = approve(flow, 1L, true);
            if (ALL_PASSED.equals(res)) {
                throw new RuntimeException("��������ȫ��ͨ��");
            } else if (REJECTED.equals(res)) {
                throw new RuntimeException("�������Ѳ���");
            } else if (CAN_NOT_APPROVE.equals(res)) {
                throw new RuntimeException("����û�����������ǰ�ڵ�");
            } else if (USER_APPROVED.equals(res)) {
                throw new RuntimeException("����û�����������ǰ�ڵ�");
            }

            System.out.println("�������: " + res);
            System.out.println("��������ͨ��: " + allPassed(res));
            System.out.println("�������Ѳ���: " + isRejected(res));
            System.out.println("����������: " + getRateOfProgress(res));
            System.out.println();

            long eTime = System.currentTimeMillis();
            System.out.println("��ʱ: " + (eTime - sTime) + "ms");
        }
    }


    /**
     * ִ������
     * @author Frank.Tang
     * @param flow ������
     * @param approvalUser ������id
     * @param passOrReject true --> ͨ�� / false --> ����
     * @return all_passed ����������ȫͨ��
     *         can_not_approve ��ǰ�û���������
     *         rejected �������ѱ�����
     *         flow �����ɹ�
     */
    private static String approve(String flow, Long approvalUser, boolean passOrReject) {
        return approve(flow, approvalUser.toString(), passOrReject);
    }

    /**
     * ִ������
     * @author Frank.Tang
     * @param flow ������
     * @param approvalUser ������id
     * @param passOrReject true --> ͨ�� / false --> ����
     * @return rejected �������ѱ�����
     *         all_passed ����������ȫͨ��
     *         can_not_approve ��ǰ�û���������
     *         flow �����ɹ�
     */
    private static String approve(String flow, String approvalUser, boolean passOrReject) {
        String[] nodeArr = flow.split(NODE_SP);

        //��������ͨ��
        if (allPassed(flow)) {
            return ALL_PASSED;
        }

        //�������Ѳ���
        if (isRejected(flow)) {
            return REJECTED;
        }

        //�õ�ǰ�����ڵ�
        String currentApproveNode = getCurrentApproveNode(flow);

        //ͨ��
        if (passOrReject) {
            return pass(nodeArr, currentApproveNode, approvalUser);
        }
        //����
        else {
            return reject(nodeArr, currentApproveNode, approvalUser);
        }
    }

    /**
     * ͨ��
     * @author Frank.Tang
     * @return *
     */
    private static String pass(String[] nodeArr, String currentApproveNode, String approvalUser) {
        //�����Ľڵ��б�
        List<String> newNodeList = new ArrayList<>();
        //�ҵ�������
        boolean findTargetUser = false;
        //Ŀ��ڵ�������(��ֹ������ͬ�˽ڵ�����)
        boolean currentNodeApproved = false;

        for (String node : nodeArr) {
            //�ǵ�ǰ�����ڵ�, ����
            if (!currentApproveNode.equals(node)) {
                newNodeList.add(node);
                continue;
            }
            //true --> ��ǩ / false --> ��ǩ
            boolean counterSign = node.startsWith(AND);
            //�ڵ��û�
            String[] userArr = node.split(USER_SP);

            ///////////////////////////////////////��ǩ///////////////////////////////////////
            List<String> nodeUserList = new ArrayList<>();
            if (counterSign) {
                int passCount = 0;
                for (String tempUser : userArr) {
                    //ȥ���ڵ���β�� "��/��"
                    tempUser = tempUser.replaceAll(OR_AND_REGEX, "");

                    //�������ͨ��
                    if (tempUser.endsWith(PASS)) {
                        //Ŀ���û��Ѿ�������
                        if (tempUser.equals(approvalUser + PASS)) {
                            return USER_APPROVED;
                        }
                        nodeUserList.add(tempUser);
                        passCount++;
                        continue;
                    }
                    //�ҵ����������
                    if (!findTargetUser && approvalUser.equals(tempUser)) {
                        nodeUserList.add(tempUser + PASS);
                        findTargetUser = true;
                        passCount++;
                    }
                    //û�ҵ����������
                    else {
                        nodeUserList.add(tempUser);
                    }
                }

                //����ڵ���, û�ҵ�������
                if (!findTargetUser) {
                    return CAN_NOT_APPROVE;
                }
                //ƴ���û�id
                else {
                    node = StringUtils.join(nodeUserList, USER_SP);
                }

                //��ǰ�ڵ���, ��������ͨ��
                if (passCount == userArr.length) {
                    node = AND + node + AND + PASS;
                }
                //����ڵ㻹��Ҫ��
                else {
                    node = AND + node + AND;
                }
            }
            ///////////////////////////////////////��ǩ///////////////////////////////////////
            else {
                for (String tempUser : userArr) {
                    //ȥ���ڵ���β�� "��/��"
                    tempUser = tempUser.replaceAll(OR_AND_REGEX, "");

                    //�������ͨ��
                    if (tempUser.endsWith(PASS)) {
                        nodeUserList.add(tempUser);
                        continue;
                    }
                    //�ҵ���ǰ������
                    if (!findTargetUser && approvalUser.equals(tempUser)) {
                        nodeUserList.add(tempUser + PASS);
                        findTargetUser = true;
                    } else {
                        nodeUserList.add(tempUser);
                    }
                }
                //����ڵ���, û�ҵ�������
                if (!findTargetUser) {
                    return CAN_NOT_APPROVE;
                }
                //����ֱ�ӹ�
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
     * ����
     * @author Frank.Tang
     * @return *
     */
    private static String reject(String[] nodeArr, String currentApproveNode, String approvalUser) {
        List<String> newNodeList = new ArrayList<>();
        //�ҵ�������
        boolean findTargetUser = false;
        //Ŀ��ڵ�������(��ֹ������ͬ�˽ڵ�����)
        boolean currentNodeApproved = false;

        for (String node : nodeArr) {
            //�ǵ�ǰ�����ڵ�, ����
            if (!currentApproveNode.equals(node)) {
                newNodeList.add(node);
                continue;
            }
            //true --> ��ǩ / false --> ��ǩ
            boolean counterSign = node.startsWith(AND);
            //�ڵ��û�
            String[] userArr = node.split(USER_SP);

            List<String> nodeUserList = new ArrayList<>();
            for (String tempUser : userArr) {
                //ȥ���ڵ���β�� "��/��"
                tempUser = tempUser.replaceAll(OR_AND_REGEX, "");

                //Ŀ���û��Ѿ�������
                if (tempUser.equals(approvalUser + PASS)) {
                    return USER_APPROVED;
                }

                //�ҵ����������
                if (!findTargetUser && approvalUser.equals(tempUser)) {
                    nodeUserList.add(tempUser + REJECT);
                    findTargetUser = true;
                }
                //û�ҵ����������
                else {
                    nodeUserList.add(tempUser);
                }
            }

            //����ڵ���, û�ҵ�������
            if (!findTargetUser) {
                return CAN_NOT_APPROVE;
            }
            //�ҵ�Ŀ��������, �����ڵ��Ϊ����
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
     * �õ���������ǰ��Ҫ�����Ľڵ�
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
     * �������Ƿ��Ѳ���
     * @author Frank.Tang
     * @param flow ������
     * @return true ---> �������Ѳ���
     *         false --> ������δ����
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
     * �жϽڵ��Ƿ�ȫͨ��
     * @author Frank.Tang
     * @param flow ������
     * @return true ---> ��������ȫ��ͨ��
     *         false --> ��������ûͨ��
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
     * ��ȡ����������
     * @author Frank.Tang
     * @param flow ������
     * @return ����ڵ���/�ܽ����
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
