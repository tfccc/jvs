package pac05_Thread;

/**
 * @author TFC
 * @date   2019��7��18�� ����3:58:44
 * @note   ������ӰԺ�������߳�ģ��ӰԺ��Ʊ��
 */
public class T19_Cinema {
	public static void main(String[] args) {
		Cinema c=new Cinema(3, "����������");
		new Thread(new Customer(c, 2),"�˿�1").start();
		new Thread(new Customer(c, 1),"�˿�2").start();
	}
}

//��Ʊ��
class Customer implements Runnable{
	Cinema cinema;
	int seats;
	
	public Customer(Cinema cinema, int seats) {
		this.cinema = cinema;
		this.seats = seats;
	}

	@Override
	public void run() {
		synchronized (cinema) {
			boolean flag=cinema.bookTicket(seats);
			if(flag) {
				System.out.println("��Ʊ�ɹ�����>"+"��Ʊ��:"+
						Thread.currentThread().getName()+
						"	����"+seats);
			}
			else { System.out.println("��Ʊʧ��......"); }
		}
		
	}
}
//ӰԺ
class Cinema{
	int available;	//����λ��
	String name;	//����
	public Cinema(int available,String name) {
		this.available=available;
		this.name=name;
	}
	//��Ʊ����
	boolean bookTicket(int seats) {
		System.out.println("����λ��Ϊ:"+available);
		//�����Ʊ������ʣ���λ��
		if(seats>available) { return false; }
		
		available-=seats;
		
		return true;
		
	}
}