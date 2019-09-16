
public class Calendar {

	public static void main(String[] args) {
		Calendar calendar = new Calendar();
		calendar.print("Januari");
	}

	void print(String month) {
		int startday;
		int lastday;

		switch (month) {
		case "Januari":
			startday = 2;
			lastday = 31;
			break;

		case "Februari":
			startday = 5;
			lastday = 28;
			break;

		case "Maart":
			startday = 5;
			lastday = 31;
			break;

		case "April":
			startday = 1;
			lastday = 30;
			break;

		case "Mei":
			startday = 3;
			lastday = 31;
			break;

		case "Juni":
			startday = 6;
			lastday = 30;
			break;

		case "Juli":
			startday = 1;
			lastday = 31;
			break;

		case "Augustus":
			startday = 4;
			lastday = 31;
			break;

		case "September":
			startday = 7;
			lastday = 30;
			break;

		case "Oktober":
			startday = 2;
			lastday = 31;
			break;

		case "November":
			startday = 5;
			lastday = 30;
			break;

		case "December":
			startday = 7;
			lastday = 31;
			break;

		default:
			startday = 1;
			lastday = 31;
			break;
		}
		
		this.printHeader(month);
		this.printCalendar(startday, lastday);
	}

	void printCalendar(int start, int last) {
		int startday = start;
		int i = 1;

		this.printBeginSpaces(start);

		while (i <= last) {
			System.out.print(i);
			
			if (i < 10) System.out.print(" ");

			System.out.print(" ");

			i++;
			startday++;

			if (startday > 7) {
				startday = 1;
				System.out.println();
			}
		}
	}

	void printHeader(String month) {
		System.out.println("2019");
		System.out.println(month);
		System.out.println("Ma Di Wo Do Vr Za Zo");
	}
	
	void printBeginSpaces(int start) {
		int spaces = 0;
		while (spaces < (start - 1) * 3) {
			System.out.print(" ");
			spaces++;
		}
	}
}
