/*
 * 이름: 최수빈
 * 학번: 2025100066
 * 과목명: 자바프로그래밍(01분반)
 */

package homework02;

public class Rectangle {
	//상태(멤버 변수)
	private int x,y;
	private int width,height;
	private String color = "white"; //추가 질문 2번,색상 추가
	
	//왼쪽 위 좌표 정보,폭,높이를 받는 생성자
	public Rectangle(int x,int y,int width,int height)
	{
		this.x = (x>=0)? x:0;
		this.y = (y>=0)? y:0;
		this.width = (width>0)? width:1;
		this.height = (width>0)? height:1;

	}
	
	//행위(매소드)
	
	//높이 폭 반환
	public int getWidth( ) {return width;} 
	public int getHeight() {return height;}
	
	//(추가 질문2)색상 반환
	public String getColor() { return color;}
	
	//면적 계산
	public int area() { return width * height;}
	
	//정사각형인지 검사
	public boolean isSquare() {return width == height;}
	
	
	//좌표 정보를 변경 단,음수가 될시 기본값
	public void moveTo(int x, int y)
	{
		if(x>=0 && y>=0)
		{
			this.x = x;
			this.y = y;
		}
	}
	
	
	//좌표를 deltaX와 deltaY만큼 이동
	public void moveBy(int deltaX, int deltaY)
	{
		moveTo(x+deltaX,y+deltaY);
	}
	
	 /*
     * (추가 질문1) x, y 대신 Point 객체를 멤버 변수로 유지하는 경우
     *
     * 가정: Point 클래스를 정의하고, Rectangle 은 int x, y 대신
     *       Point 타입의 멤버 변수 topLeft 를 가진다.
     *
     *   class Point {
     *       int x, y;
     *       Point(int x, int y) { this.x = x; this.y = y; }
     *   }
     *
     *   private Point topLeft;  
     *
     * 바뀌는 점
     *   x, y 를 직접 쓰던 부분이 topLeft.x, topLeft.y 로 바뀐다.
     *   좌표를 바꿀 때는 새 Point 객체를 만들어 topLeft 에 대입한다.
     *
     *   public void moveTo(int x, int y) {
     *       if (x >= 0 && y >= 0) {
     *           topLeft = new Point(x, y);
     *       }
     *   }
     *
     *   public void moveBy(int deltaX, int deltaY) {
     *       moveTo(topLeft.x + deltaX, topLeft.y + deltaY);
     *   }
     
     */
	
	//주어진 좌표가 사각형 내에 있는지 판단
	public boolean isInside(int x,int y)
	{
		boolean insideX = x > this.x && x < this.x + width;
		boolean insideY = y > this.x && y < this.y + width;
		return insideX && insideY;
	}
	
	//(추가 질문2) 색상 변경
	public void setColor(String color) {
        if (color != null && !color.isEmpty()) {
            this.color = color;
        }
    }
	
	 static void testRectangle() {
		 Rectangle rect = new Rectangle(10, 10, 100, 200);
		 System.out.println(rect.isSquare());
		 System.out.println(rect.isInside(30, 10));
		 rect.moveBy(-10, 10);
		 System.out.println(rect.isInside(30, 30));
		 rect.setColor("blue");
		 System.out.println(rect.getColor()); 

		 
	    }
	 
	    public static void main(String[] args) {
	        testRectangle();
	    }
	
}

