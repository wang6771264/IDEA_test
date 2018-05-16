import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test1 {
	public static void main(String[] args) {
		//Integer a = null;
		//a = (a == null) ? 1 : a;
		//Short x = new Short((short)1);
		//Short y = 1;
		//System.out.println(x == y);
		//Integer b = new Integer(1);
		//Integer c = 1;
		//System.out.println(b == c);
		//Order or = new Order();
		//or.setTitle((short)1);
		//System.out.println(or.getTitle() == Person.PERSON.getCode());

		//String str="1#2#3";
		//String[] strs=str.split("#");
		//System.out.println(strs.length);
		//int length = str.length() - str.replaceAll("#", "").length();
		//if(strs.length != length){
		//	System.out.println("证明分隔符中间存在空值");
		//}
		//System.out.println(1/0);
		//String str = "王威测试Directionality方法<>&";
		//for (int i=0;i<str.length();i++) {
		//	System.out.println(Character.getDirectionality(str.charAt(i)));
		//}

		//Scanner scan = new Scanner(System.in);
        //
		//// Read a full line of input from stdin and save it to our variable, inputString.
		//String inputString = scan.nextLine();
        //
		//// Close the scanner object, because we've finished reading
		//// all of the input from stdin needed for this challenge.
		//scan.close();
        //
		//// Print a string literal saying "Hello, World." to stdout.
		//System.out.println("Hello, World.");

		//long x = 21266;
		//System.out.println((double)x / 100);
		//System.out.println(getAreaLeaderByPlaceId(10801));
		//Date d = DateUtils.round(new Date(), Calendar.HOUR);
		//System.out.println(d);

		//new Date(startTime).getMinutes();
		System.out.println(new Integer(1) == new Integer(1));
	}

	public static Long getAreaLeaderByPlaceId(Integer placeId){
		boolean flag = false;
		if(placeId.toString().startsWith("108")){
			flag = true;
		}

		List<SpecialDepartment> lstSpe = new ArrayList<>();
		SpecialDepartment spe = new SpecialDepartment();
		lstSpe.add(spe);
		spe.setLcbUserId(111L);
		spe.setPlaceIds("10801,10802,10803");

		SpecialDepartment spe1 = new SpecialDepartment();
		lstSpe.add(spe1);
		spe1.setLcbUserId(121L);
		spe1.setPlaceIds("10601,10602,10703");

		for (int i = 0; i < lstSpe.size(); i++) {
			String placeIds = lstSpe.get(i).getPlaceIds();
			String plId = Arrays.asList(placeIds.split(",")).get(0);
			if(plId.matches("^108\\d{2}$") && flag){
				return spe.getLcbUserId();
			}
			return lstSpe.get(++i).getLcbUserId();
		}
		return null;
	}

	public static class SpecialDepartment {
		private Long lcbUserId;
		private String placeIds;
		public Long getLcbUserId( ) {
			return lcbUserId;
		}

		public void setLcbUserId(Long lcbUserId) {
			this.lcbUserId = lcbUserId;
		}

		public String getPlaceIds( ) {
			return placeIds;
		}

		public void setPlaceIds(String placeIds) {
			this.placeIds = placeIds;
		}
	}

}
