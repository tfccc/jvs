package pac15_Keyword;

/**
 * @author TFC
 * @date 2019��6��15�� ����10:19:54
 * @note ö�ٲ���
 *
 * һ.˵��
 *	 1.enum�൱��һ���࣬��ų�Ա�����������Ķ���ʹ��
 *	 2.��Ա����Ĭ������public static final
 *
 * ��.���ü��ŵ�
 *	 1.��ǿ����ɶ���
 *	 2.��������:����ʱ��û�аѳ���ֵ���뵽�����У���ʹ����ֵ�����ı䣬
 *	   Ҳ����Ӱ�����ó�������
 *	 3.�޸�����:ö��������Ĭ��final class��������̳пɷ�ֹ�������޸�
 *	 4.ö���Ϳ�ֱ�������ݿ⽻��:ʹ��int��String����switchʱ�������ֲ���
 *	   ��ȷ���������ż�������Խ��������������Ǿ���Ҫ���ݴ������if
 *	   ����ɸѡ�ȣ���ʹ��ö�٣������ڼ��޶����ͣ���������Խ��
 *
 */
public class T07_Enum {

    enum WeekDay {
        ����һ, ���ڶ�, ������, ������, ������, ������, ������,
        ;

        public String getSunday() {
            return String.valueOf(������);
        }
    }

    public static void main(String[] args) {

        System.out.println(WeekDay.���ڶ�);
        WeekDay weekDay = WeekDay.����һ;
        System.out.println(weekDay);
        System.out.println(weekDay.getSunday());

    }
}
