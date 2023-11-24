package pac05_Thread;

/**
 * @author TFC
 * @date   2019年7月18日 下午3:58:44
 * @note   “快乐影院”（多线程模拟影院购票）
 */
public class T19_Cinema {
	public static void main(String[] args) {
		Cinema c=new Cinema(3, "复仇者联盟");
		new Thread(new Customer(c, 2),"顾客1").start();
		new Thread(new Customer(c, 1),"顾客2").start();
	}
}

//购票人
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
				System.out.println("出票成功——>"+"购票人:"+
						Thread.currentThread().getName()+
						"	数量"+seats);
			}
			else { System.out.println("出票失败......"); }
		}
		
	}
}
//影院
class Cinema{
	int available;	//可用位置
	String name;	//名称
	public Cinema(int available,String name) {
		this.available=available;
		this.name=name;
	}
	//购票方法
	boolean bookTicket(int seats) {
		System.out.println("可用位置为:"+available);
		//如果购票数大于剩余的位置
		if(seats>available) { return false; }
		
		available-=seats;
		
		return true;
		
	}
}