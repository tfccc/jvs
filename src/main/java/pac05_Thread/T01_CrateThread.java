package pac05_Thread;

/**
 * @author TFC
 * @date 2019��7��14�� ����2:46:03
 * @note �����߳�
 *
 * ����������
 *	 1.�̳�Thread��,��дrun()
 *	 2.ʵ��Runnable�ӿ�,��дrun()
 *	 3.ʵ��Callable�ӿ�,��дcall()
 *
 */
public class T01_CrateThread extends Thread {

    @Override
    public void run() {
        System.out.println("�����߳�: " + this.getName());
        for (int i = 0; i < 500; i++) {
            System.out.println("��������������");
        }
    }

    public static void main(String[] args) {
        //�����������,������������start(),������������·��(main/st)
        T01_CrateThread st = new T01_CrateThread();
        st.setName("�߳�2: �̳�Threadʵ��");

        //����������д��run(),ʵ���̵߳Ĵ���
        st.start();
        for (int i = 0; i < 500; i++) {
            System.out.println("****");
        }
    }
}
