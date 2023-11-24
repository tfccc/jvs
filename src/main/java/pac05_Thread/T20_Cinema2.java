package pac05_Thread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import utils.TravelCollection;

/**
 * @author TFC
 * @date   2019年7月18日 下午4:31:44
 * @note   影院修改版
 */
public class T20_Cinema2 {
	public static void main(String[] args) throws InterruptedException {
		buy();
	}
	
	static void buy() throws InterruptedException {
		//添加座位
		List<Integer> seats=new ArrayList<>();
		for(int i=1;i<=10;i++) { seats.add(i); }
		
		Cinema2 cinema=new Cinema2(seats, "复仇者联盟");
		
		new Thread(new Customer2(cinema, seats, 5),"A").start();
		new Thread(new Customer2(cinema, seats, 2),"B").start();
		new Thread(new Customer2(cinema, seats, 2),"C").start();
		new Thread(new Customer2(cinema, seats, 3),"D").start();
		new Thread(new Customer2(cinema, seats, 2),"E").start();
		
		Thread.sleep(20);
		System.out.println("剩余座位号:");
		TravelCollection.travelList(seats,false);

	}
}

class Customer2 implements Runnable{
	Cinema2 cinema;
	List<Integer> seats;
	int number;
	public Customer2(Cinema2 cinema, List<Integer> seats,int number) {
		this.cinema = cinema;
		this.seats = seats;
		this.number=number;
	}

	@Override
	public void run() {
		synchronized(cinema) {
			boolean flag=cinema.bookticket(number, seats);
			if(flag) {
				System.out.println(Thread.currentThread().getName()+
						":购票成功\n"+
						"电影:"+cinema.filmName+"   座位号:"+number+"\n");
			}
			else {
				System.out.println(Thread.currentThread().getName()+
						":购票失败\n");
			}
		}	
	}
}

class Cinema2{
	//Integer(座位编号/排数)
	List<Integer> seats;
	String filmName;
	public Cinema2(List<Integer> seats, String filmName) {
		this.seats    = seats;
		this.filmName = filmName;
	}
	
	boolean bookticket(int number,List<Integer> seats) {
		
		if(!seats.contains(number)) {
			return false;
		}
		else {
			Iterator<Integer> it = seats.iterator();
	        while(it.hasNext()){
	            int num = it.next();
	            if(num==number){
	                it.remove();
	            }
	        }
			this.seats=seats;
			return true;
		}
	}
	
}