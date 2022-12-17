import java.util.*;

public class Game2048 {

/**새로 나올 수 지정, 10퍼 확률로 4 등장 **/
public static int random_number(){
	int r = (int)((Math.random()*10000)%10);
	if (r == 1) {return 4;}
	else {return 2;}
}

/** 새로 나올 수 자리 랜덤 지정**/
public static int random_locate(){

	int random_locate_number = (int)((Math.random()*10000)%15);
	return random_locate_number;
	
}
/**판 만들기 */
public static LinkedList<Integer> board(){
	LinkedList<Integer> list = new LinkedList<Integer>();
	for(int i=0;i<17;i++){
		list.add(0);
	}
	return list;
}
/**더이상 게임이 진행될 수 있는지 판단 */
public static Boolean game_over(LinkedList<Integer> list,LinkedList<Integer> list1){
	int count = 0;
	Boolean result = false;
	for(int l=0; l<16;l++){ //16칸이 꽉 차있다면
		if(list.get(l)!=0){
			count ++;
		}	
	}

	if(count==16){
		if(count==16){
			if(up(list1).equals(list)!=false){ //up down left right 한번씩 다 시켜보기
				if(down(list1).equals(list)!=false){
					if(left(list1).equals(list)!=false){
						if(right(list1).equals(list)!=false){
							System.out.println("게임오바");
							result = true;
						}
					}
				}
			}
		}
	}
	return result;
}
/**판에 숫자 넣기*/
public static LinkedList<Integer> board_number(LinkedList<Integer> list){

	int a = random_number();


	
	for(int i=0; i<16;i++){ //순서대로 숫자 넣어주기
		if((int)list.get(i)==0){
			list.set(i, a);
			break;
		}
	}


	return list;
	
	
}
/**판 인쇄 */

public static void board_test(LinkedList<Integer> list){
	System.out.print(list.get(0) + " " +list.get(1) + " " + list.get(2) +  " " + list.get(3));
	System.out.println();
	System.out.print(list.get(4) + " " +list.get(5) + " " + list.get(6) +  " " + list.get(7));
	System.out.println();
	System.out.print(list.get(8) + " " +list.get(9) + " " + list.get(10) +  " " + list.get(11));
	System.out.println();
	System.out.print(list.get(12) + " " +list.get(13) + " " + list.get(14) +  " " + list.get(15));
	System.out.println();
	System.out.println("####");
}
/**up일시 위 아래가 같을 떄 */
public static LinkedList<Integer> up_numberplus(LinkedList<Integer> list,int i){



	if (i<4 && (int)list.get(i)==(int)list.get(i+4) && (int)list.get(i)!=0){


		list.set(i,(int)list.get(i)*2); //1,2줄이 같을 때
		list.set(16,list.get(16)+(int)list.get(i));
		list.set(i+4,(int)list.get(i+8));
		list.set(i+8,(int)list.get(i+12));
		list.set(i+12,0);
		

		
	}		


	else if(4<=i && i<8 && (int)list.get(i)==(int)list.get(i+4) && (int)list.get(i)!=0){ // 2,3줄이 같을 때
		list.set(i,(int)list.get(i)*2);
		list.set(16,list.get(16)+(int)list.get(i));
		list.set(i+4,(int)list.get(i+8));
		list.set(i+8,0);
		


	}
	else if (8<=i && i<12 && (int)list.get(i)==(int)list.get(i+4) && (int)list.get(i)!=0 ){

		list.set(i,(int)list.get(i)*2); //3,4줄이 같을 떄
		list.set(16,list.get(16)+(int)list.get(i));
		list.set(i+4,0);
		
	}	

	

	return list;
}

/**숫자가 1(up)일 경우*/
public static LinkedList<Integer> up(LinkedList<Integer> list){
	for(int i=12; i<16; i=i+1){


		
		if((int)list.get(i)==0 && (int)list.get(i-4)==0 && (int)list.get(i-8)==0 && (int)list.get(i-12)==0){
			continue;
		}
		else{
			
		if ((int)list.get(i-12)==0 && (int)list.get(i-8)==0 && (int)list.get(i-4)==0 && (int)list.get(i)!=0){
			//0002
			list.set(i-12,list.get(i));
			list.set(i,0);
		}
		else if ((int)list.get(i-12)==0 && (int)list.get(i-8)==0 && (int)list.get(i-4)!=0 && (int)list.get(i)==0){
			list.set(i-12,list.get(i-4));
			list.set(i-4,0); //0020
		}
		else if ((int)list.get(i-12)==0 && (int)list.get(i-8)!=0 && (int)list.get(i-4)==0 && (int)list.get(i)==0){
			//0200
			list.set(i-12,list.get(i-8));
			list.set(i-8,0);
		}
		else if((int)list.get(i-12)!=0 && (int)list.get(i-8)==0 && (int)list.get(i-4)==0 && (int)list.get(i)==0){
//2000		
			continue;
		}
		
		else if ((int)list.get(i-12)==0 && (int)list.get(i-8)==0 && (int)list.get(i-4)!=0 && (int)list.get(i)!=0){
			//0022
			list.set(i-12,list.get(i-4));
			list.set(i-8,list.get(i));
			list.set(i-4,0);
			list.set(i,0);
		}
		else if ((int)list.get(i-12)==0 && (int)list.get(i-8)!=0 && (int)list.get(i-4)!=0 && (int)list.get(i)==0){
			list.set(i-12,list.get(i-8));
			list.set(i-8,list.get(i-4));
			list.set(i-4,0); //0220
		}
		else if ((int)list.get(i-12)==0 && (int)list.get(i-8)!=0 && (int)list.get(i-4)==0 && (int)list.get(i)!=0){
			//0202
			list.set(i-12,list.get(i-8));
			list.set(i-8,0);
			list.set(i-4,list.get(i));
			list.set(i,0);
		}
		else if ((int)list.get(i-12)!=0 && (int)list.get(i-8)==0 && (int)list.get(i-4)!=0 && (int)list.get(i)==0)
		{
			list.set(i-8,list.get(i-4));
			list.set(i-4,0); //2020
		}
		else if ((int)list.get(i-12)!=0 && (int)list.get(i-8)==0 && (int)list.get(i-4)==0 && (int)list.get(i)!=0)
		{//2002
			list.set(i-8,list.get(i));
			list.set(i,0);
		}
		else if ((int)list.get(i-12)!=0 && (int)list.get(i-8)!=0 && (int)list.get(i-4)==0 && (int)list.get(i)==0)
		{
			//2200
			continue;
			
		}
		else if ((int)list.get(i-12)!=0 && (int)list.get(i-8)!=0 && (int)list.get(i-4)!=0 && (int)list.get(i)==0)
		{
			//2220
			continue;
		}
		else if ((int)list.get(i-12)!=0 && (int)list.get(i-8)!=0 && (int)list.get(i-4)==0 && (int)list.get(i)!=0)
		{
			//2202
			list.set(i-4,list.get(i));
			list.set(i,0);
		}
		else if((int)list.get(i-12)!=0 && (int)list.get(i-8)==0 && (int)list.get(i-4)!=0 && (int)list.get(i)!=0){
			//2022
			list.set(i-8,list.get(i-4));
			list.set(i-4,list.get(i));
			list.set(i,0);
		}
		else if ((int)list.get(i-12)==0 && (int)list.get(i-8)!=0 && (int)list.get(i-4)!=0 && (int)list.get(i)!=0){
			//0222
			list.set(i-12,list.get(i-8));
			list.set(i-8,list.get(i-4));
			list.set(i-4,list.get(i));
			list.set(i,0);
		}

			continue;
		}
		
	}
	

	//0222
	//2222

	

	for (int i =0; i<16; i++){
		up_numberplus(list,i);	
	}



	return list;
}



/**down시 위 아래가 같을떄 */
public static LinkedList<Integer> down_numberplus(LinkedList<Integer> list,int i){


	if(i>11 && (int)list.get(i)==(int)list.get(i-4) && i!=0){ // 3,4줄이 같을 때
		list.set(i,(int)list.get(i)*2);
		list.set(16,list.get(16)+(int)list.get(i));
		list.set(i-4,(int)list.get(i-8));
		list.set(i-8,(int)list.get(i-12));
		list.set(i-12,0);

	}
	else if (i>7 && (int)list.get(i)==(int)list.get(i-4) && (int)list.get(i)!=0){
		list.set(i,(int)list.get(i)*2);
		list.set(i-4,(int)list.get(i-8));
		list.set(i-8,0);
		 //2,3줄이 같을 떄

		list.set(16,list.get(16)+(int)list.get(i));



	}	
	
	else if (i>3 && (int)list.get(i)==(int)list.get(i-4) && (int)list.get(i)!=0){
		list.set(i,(int)list.get(i)*2); //1,2줄이 같을 때
		list.set(16,list.get(16)+(int)list.get(i));
		list.set(i-4,0);
	}	

	return list;
}

public static LinkedList<Integer> down(LinkedList<Integer> list){
	for(int i=12; i<16; i=i+1){


		
		if((int)list.get(i)==0 && (int)list.get(i-4)==0 && (int)list.get(i-8)==0 && (int)list.get(i-12)==0){
			continue;
		}
		else{

		if ((int)list.get(i-12)==0 && (int)list.get(i-8)==0 && (int)list.get(i-4)==0 && (int)list.get(i)!=0){
			//0002
			continue;
		}
		else if ((int)list.get(i-12)==0 && (int)list.get(i-8)==0 && (int)list.get(i-4)!=0 && (int)list.get(i)==0){
			list.set(i,list.get(i-4));
			list.set(i-4,0); //0020
		}
		else if ((int)list.get(i-12)==0 && (int)list.get(i-8)!=0 && (int)list.get(i-4)==0 && (int)list.get(i)==0){
			//0200
			list.set(i,list.get(i-8));
			list.set(i-8,0);
		}
		else if((int)list.get(i-12)!=0 && (int)list.get(i-8)==0 && (int)list.get(i-4)==0 && (int)list.get(i)==0){
//2000		
			list.set(i,list.get(i-12));
			list.set(i-12,0);
		}
		
		else if ((int)list.get(i-12)==0 && (int)list.get(i-8)==0 && (int)list.get(i-4)!=0 && (int)list.get(i)!=0){
			//0022
			continue;
		}
		else if ((int)list.get(i-12)==0 && (int)list.get(i-8)!=0 && (int)list.get(i-4)!=0 && (int)list.get(i)==0){
			list.set(i,list.get(i-4));
			list.set(i-4,list.get(i-8));
			list.set(i-8,0); //0220
		}
		else if ((int)list.get(i-12)==0 && (int)list.get(i-8)!=0 && (int)list.get(i-4)==0 && (int)list.get(i)!=0){
			//0202
			list.set(i-4,list.get(i-8));
			list.set(i-8,0);

		}
		else if ((int)list.get(i-12)!=0 && (int)list.get(i-8)==0 && (int)list.get(i-4)!=0 && (int)list.get(i)==0)
		{	list.set(i,list.get(i-4));
			list.set(i-4,list.get(i-12));
			list.set(i-12,0); //2020
		}
		else if ((int)list.get(i-12)!=0 && (int)list.get(i-8)==0 && (int)list.get(i-4)==0 && (int)list.get(i)!=0)
		{//2002
			list.set(i-4,list.get(i-12));
			list.set(i-12,0);
		}
		else if ((int)list.get(i-12)!=0 && (int)list.get(i-8)!=0 && (int)list.get(i-4)==0 && (int)list.get(i)==0)
		{
			//2200
			list.set(i,list.get(i-8));
			list.set(i-4,list.get(i-12));
			list.set(i-8,0);
			list.set(i-12,0);
			
		}
		else if ((int)list.get(i-12)!=0 && (int)list.get(i-8)!=0 && (int)list.get(i-4)!=0 && (int)list.get(i)==0)
		{
			//2220
			list.set(i,list.get(i-4));
			list.set(i-4,list.get(i-8));
			list.set(i-8,list.get(i-12));
			list.set(i-12,0);
		}
		else if ((int)list.get(i-12)!=0 && (int)list.get(i-8)!=0 && (int)list.get(i-4)==0 && (int)list.get(i)!=0)
		{
			//2202
			list.set(i-4,list.get(i-8));
			list.set(i-8,list.get(i-12));
			list.set(i-12,0);
		}
		else if((int)list.get(i-12)!=0 && (int)list.get(i-8)==0 && (int)list.get(i-4)!=0 && (int)list.get(i)!=0){
			//2022
			list.set(i-8,list.get(i-12));
			list.set(i-12,0);
		}

		else{

			continue;
		}
	
	}
	}


	
	for(int i=15; i>-1;i--){
		down_numberplus(list, i);

	}


return list;
}
public static LinkedList<Integer> left_numberplus(LinkedList<Integer> list){
	//1,2열 같을 때
for(int i=0; i<16;i=i+4){
	if((int)list.get(i)==(int)list.get(i+1) && (int)list.get(i)!=0){ // 1,2열이 같을 때
		list.set(i,(int)list.get(i+1)*2);
		list.set(i+1,list.get(i+2));
		list.set(i+2,(int)list.get(i+3));
		list.set(i+3,0);
		list.set(16,list.get(16)+(int)list.get(i)); //점수계산
	}
	else if ((int)list.get(i+1)==(int)list.get(i+2) && (int)list.get(i+1)!=0){ //2,3열 같을때
		list.set(1+i,(int)list.get(i+1)*2);
		list.set(16,list.get(16)+(int)list.get(i+1)); //점수계산
		list.set(i+2,(int)list.get(i+3));
		list.set(i+3,0);



	}	
	
	else if ((int)list.get(i+2)==(int)list.get(i+3) && (int)list.get(i+2)!=0){
		list.set(2+i,(int)list.get(i+3)*2);
		list.set(i+3,0);
		list.set(16,list.get(16)+(int)list.get(i+2)); //점수계산


	}	

	

}
	return list;	

}
public static LinkedList<Integer> left(LinkedList<Integer> list){
	for(int i=0; i<16; i=i+4){


		
		if((int)list.get(i)==0 && (int)list.get(i+1)==0 && (int)list.get(i+2)==0 && (int)list.get(i+3)==0){
			continue;
		}
		else{

		if ((int)list.get(i)==0 && (int)list.get(i+1)==0 && (int)list.get(i+2)==0 && (int)list.get(i+3)!=0){
			//0002
			list.set(i,list.get(i+3));
			list.set(i+3,0);

		}
		else if ((int)list.get(i)==0 && (int)list.get(i+1)==0 && (int)list.get(i+2)!=0 && (int)list.get(i+3)==0){
			list.set(i,list.get(i+2));
			list.set(i+2,0); //0020
		}
		else if ((int)list.get(i)==0 && (int)list.get(i+1)!=0 && (int)list.get(i+2)==0 && (int)list.get(i+3)==0){
			//0200
			list.set(i,list.get(i+1));
			list.set(i+1,0);
		}
		else if((int)list.get(i)!=0 && (int)list.get(i+1)==0 && (int)list.get(i+2)==0 && (int)list.get(i+3)==0){
//2000		
			continue;
		}
		
		else if ((int)list.get(i)==0 && (int)list.get(i+1)==0 && (int)list.get(i+2)!=0 && (int)list.get(i+3)!=0){
			//0022
			list.set(i,list.get(i+2));
			list.set(i+1,list.get(i+3));
			list.set(i+2,0);
			list.set(i+3,0);
		}
		else if ((int)list.get(i)==0 && (int)list.get(i+1)!=0 && (int)list.get(i+2)!=0 && (int)list.get(i+3)==0){
			list.set(i,list.get(i+1));
			list.set(i+1,list.get(i+2));
			list.set(i+2,0); //0220
		}
		else if ((int)list.get(i)==0 && (int)list.get(i+1)!=0 && (int)list.get(i+2)==0 && (int)list.get(i+3)!=0){
			//0202
			list.set(i,list.get(i+1));
			list.set(i+1,list.get(i+3));
			list.set(i+3,0);


		}
		else if ((int)list.get(i)!=0 && (int)list.get(i+1)==0 && (int)list.get(i+2)!=0 && (int)list.get(i+3)==0)
		{	list.set(i+1,list.get(i+2));
			list.set(i+2,0); //2020
		}
		else if ((int)list.get(i)!=0 && (int)list.get(i+1)==0 && (int)list.get(i+2)==0 && (int)list.get(i+3)!=0)
		{//2002
			list.set(i+1,list.get(i+3));
			list.set(i+3,0);
		}
		else if ((int)list.get(i)!=0 && (int)list.get(i+1)!=0 && (int)list.get(i+2)==0 && (int)list.get(i+3)==0)
		{
			//2200 여기서부터
			continue;
			
		}
		else if ((int)list.get(i)!=0 && (int)list.get(i+1)!=0 && (int)list.get(i+2)!=0 && (int)list.get(i+3)==0)
		{
			//2220
			continue;
		}
		else if ((int)list.get(i)!=0 && (int)list.get(i+1)!=0 && (int)list.get(i+2)==0 && (int)list.get(i+3)!=0)
		{
			//2202
			list.set(i+2,list.get(i+3));
			list.set(i+3,0);
		}
		else if((int)list.get(i)!=0 && (int)list.get(i+1)==0 && (int)list.get(i+2)!=0 && (int)list.get(i+3)!=0){
			//2022
			list.set(i+1,list.get(i+2));
			list.set(i+2,list.get(i+3));
			list.set(i+3,0);
		}
		else if ((int)list.get(i)==0 && (int)list.get(i+1)!=0 && (int)list.get(i+2)!=0 && (int)list.get(i+3)!=0){
			//0222
			list.set(i,list.get(i+1));
			list.set(i+1,list.get(i+2));
			list.set(i+2,list.get(i+3));
			list.set(i+3,0);
		}

		else{

			continue;
		}


	}

	
}
left_numberplus(list);
return list;
	}


public static LinkedList<Integer> right_numberplus(LinkedList<Integer> list){

	for(int i=0; i<16;i=i+4){
	if((int)list.get(i+2)==(int)list.get(i+3) && (int)list.get(i+2)!=0){ // 3,4열이 같을 때
		list.set(3+i,(int)list.get(i+2)*2);
		list.set(2+i,(int)list.get(i+1));
		list.set(1+i,(int)list.get(i));
		list.set(i,0);

		list.set(16,list.get(16)+(int)list.get(i+3));

	}
	else if ((int)list.get(i+2)==(int)list.get(i+1) && (int)list.get(i+1)!=0){ //2,3열 같을때
		
		list.set(2+i,(int)list.get(i+1)*2);

		list.set(1+i,(int)list.get(i));
		list.set(i,0);

		list.set(16,list.get(16)+(int)list.get(i+2));

	}	
	
	else if ((int)list.get(i+1)==(int)list.get(i) && (int)list.get(i)!=0){
		list.set(1+i,(int)list.get(i)*2);
		list.set(i,0);
		list.set(16,list.get(16)+(int)list.get(i+1));
	}	
}
	return list;	

}
// left, right 구형
public static LinkedList<Integer> right(LinkedList<Integer> list){

	for(int i=0; i<16; i=i+4){


		
		if((int)list.get(i)==0 && (int)list.get(i+1)==0 && (int)list.get(i+2)==0 && (int)list.get(i+3)==0){
			continue;
		}
		else{

		if ((int)list.get(i)==0 && (int)list.get(i+1)==0 && (int)list.get(i+2)==0 && (int)list.get(i+3)!=0){
			//0002
			continue;

		}
		else if ((int)list.get(i)==0 && (int)list.get(i+1)==0 && (int)list.get(i+2)!=0 && (int)list.get(i+3)==0){
			list.set(i+3,list.get(i+2));
			list.set(i+2,0); //0020
		}
		else if ((int)list.get(i)==0 && (int)list.get(i+1)!=0 && (int)list.get(i+2)==0 && (int)list.get(i+3)==0){
			//0200
			list.set(i+3,list.get(i+1));
			list.set(i+1,0);
		}
		else if((int)list.get(i)!=0 && (int)list.get(i+1)==0 && (int)list.get(i+2)==0 && (int)list.get(i+3)==0){
//2000		
			list.set(i+3,list.get(i));
			list.set(i,0);
		}
		
		else if ((int)list.get(i)==0 && (int)list.get(i+1)==0 && (int)list.get(i+2)!=0 && (int)list.get(i+3)!=0){
			//0022
			continue;
		}
		else if ((int)list.get(i)==0 && (int)list.get(i+1)!=0 && (int)list.get(i+2)!=0 && (int)list.get(i+3)==0){
			list.set(i+3,list.get(i+2));
			list.set(i+2,list.get(i+1));
			list.set(i+1,0); //0220
		}
		else if ((int)list.get(i)==0 && (int)list.get(i+1)!=0 && (int)list.get(i+2)==0 && (int)list.get(i+3)!=0){
			//0202
			list.set(i+2,list.get(i+1));
			list.set(i+1,0);
	


		}
		else if ((int)list.get(i)!=0 && (int)list.get(i+1)==0 && (int)list.get(i+2)!=0 && (int)list.get(i+3)==0)
		{	list.set(i+3,list.get(i+2));
			list.set(i+2,list.get(i)); //2020
			list.set(i,0);
		}
		else if ((int)list.get(i)!=0 && (int)list.get(i+1)==0 && (int)list.get(i+2)==0 && (int)list.get(i+3)!=0)
		{//2002
			list.set(i+2,list.get(i));
			list.set(i,0);
		}
		else if ((int)list.get(i)!=0 && (int)list.get(i+1)!=0 && (int)list.get(i+2)==0 && (int)list.get(i+3)==0)
		{
			//2200 여기서부터
			list.set(i+3,list.get(i+1));
			list.set(i+2,list.get(i));
			list.set(i+1,0);
			list.set(i,0);
			
		}
		else if ((int)list.get(i)!=0 && (int)list.get(i+1)!=0 && (int)list.get(i+2)!=0 && (int)list.get(i+3)==0)
		{
			//2220
			list.set(i+3,list.get(i+2));
			list.set(i+2,list.get(i+1));
			list.set(i+1,list.get(i));
			list.set(i,0);
		}
		else if ((int)list.get(i)!=0 && (int)list.get(i+1)!=0 && (int)list.get(i+2)==0 && (int)list.get(i+3)!=0)
		{
			//2202
			list.set(i+2,list.get(i+1));
			list.set(i+1,list.get(i));
			list.set(i,0);
		
		}
		else if((int)list.get(i)!=0 && (int)list.get(i+1)==0 && (int)list.get(i+2)!=0 && (int)list.get(i+3)!=0){
			//2022
			list.set(i+1,list.get(i));
			list.set(i,0);
	
		}
		else{

			continue;
		}

	}
	

	}
	right_numberplus(list);
	return list;
}
public static Integer game_end (LinkedList<Integer> list){
	int t = 0;
	int count = 0;
	LinkedList<Integer> list1 = new LinkedList<Integer>();
	for(int z=0;z<16;z++){
		if(list.get(z)!=0){
			count ++;
		}
	}
	if (count==16){
		for(int i=0; i<17;i++){
			list1.add(list.get(i));
		}


	}


	



	return t;

}
public static void main(String[] args) throws Exception {
	int sc = 0;
	LinkedList<Integer> list = board();
	board_number(list);	
	board_test(list);
	Scanner scan = new Scanner(System.in);
	LinkedList<Integer> list1 = new LinkedList<Integer>();
	while(true){
		for(int i=0; i<16;i++){
			list1.add(list.get(i));
		}
		
	System.out.print("위면 1, 아래면 2, 왼쪽이면 3, 오른쪽이면 4를 입력하세요 ==>");
	
	int input = scan.nextInt();
	if(input==1){
	
		up(list);

		System.out.println("점수 : " + list.get(16));
		sc = (int)list.get(16);
		list1.add(sc);

		if(list1.equals(list) != false){

			System.out.println("더해진 요소가 없어 새로운 숫자를 추가 하지 않습니다");
		}
		else{
			if(game_over(list,list1)==true){
				board_test(list);
				break;
			}
			board_test(list);
			board_number(list);	
			
		}

	}
	else if (input==2){

		down(list);

		System.out.println("점수 : " + list.get(16));
		sc = list.get(16);
		list1.add(sc);

		if(list1.equals(list) != false){

			System.out.println("더해진 요소가 없어 새로운 숫자를 추가 하지 않습니다");
		}
		else{
			if(game_over(list,list1)==true){
				board_test(list);
				break;
			}
			board_test(list);
			board_number(list);	
			
		}
		list.set(16,sc);

	}	
	else if (input==3){

		left(list);

		System.out.println("점수 : " + list.get(16));
		sc = list.get(16);
		list1.add(sc);

		if(list1.equals(list) != false){

			System.out.println("더해진 요소가 없어 새로운 숫자를 추가 하지 않습니다");
		}
		else{
			if(game_over(list,list1)==true){
				board_test(list);
				break;
			}
			board_test(list);
			board_number(list);	
			
		}
		list.set(16,sc);
	}
	else if (input==4){

		right(list);
		
		System.out.println("점수 : " + list.get(16));
		sc = list.get(16);
		list1.add(sc);

		if(list1.equals(list) != false){

			System.out.println("더해진 요소가 없어 새로운 숫자를 추가 하지 않습니다");
		}

		else{
			if(game_over(list,list1)==true){
				board_test(list);
				break;
			}
			board_test(list);
			board_number(list);	
			
		}
		list.set(16,sc);
	}
	else{
		System.out.println("올바른 키를 입력해 주세요");
	}


	if (game_over(list,list1)==true){
		board_test(list);
		break;
	}


	for(int i=0; i<17;i++){
		list1.remove(0);
	}
	




	}
	scan.close();
}
}

