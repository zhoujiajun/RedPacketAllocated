import java.util.Scanner;


public class RedPacket {
	static double[] result;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();   //红包人数
		double money = scanner.nextDouble();    //总金额
		if (n*1.0/100>money) {    //若每个人不能分至少一分钱，则显示金额太少，结束程序
			System.out.println("钱太少了，多发点给朋友们吧");
			return;
		}
		allocateRedPacket(n,100*money);   //乘以100，把元转换为分
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		scanner.close();
	}

	private static void allocateRedPacket(int n, double money) {
		// TODO Auto-generated method stub
		result = new double[n];
		double[] randNumber = new double[n];
		double randSum = 0;   //随机数和
		double allocateSum = money-n;    //按每人一分钱的计划扣出来，剩下的再分配
		for (int i = 0; i < randNumber.length; i++) {
			randNumber[i]=Math.random()*allocateSum;    //生成随机数
			randSum+=randNumber[i];
		}
		double left = allocateSum;
		for (int i = 0; i < result.length-1; i++) {			
			result[i]=Math.round(randNumber[i]/randSum*allocateSum);
			left -= result[i];
			result[i]=(result[i]+1)*1.0/100;       //把一分钱加回去
		}
		result[n-1] = (left+1)*1.0/100;
	}

}
