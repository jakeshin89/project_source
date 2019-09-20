package vo;

public class BookVO {

	int bookid;
	String bookname;
	String publisher;
	int price;
	String img;
	
	//�⺻�����ڴ� �ݵ��!
	public BookVO() {
		super();
	}

	public BookVO(String publisher) {
		super();
		this.publisher = publisher;
	}

	public BookVO(int bookid, String bookname, String publisher, int price, String img) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.publisher = publisher;
		this.price = price;
		this.img = img;
	}
	
	//set/get�� �ݵ��!
	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "BookVO [bookid=" + bookid + ", bookname=" + bookname + ", publisher=" 
	+ publisher + ", price=" + price + ", img=" + img + "]";
	}

	//PK �� ���Խ�Ű�� ������ �˾Ƽ� ����
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookid;
		result = prime * result + ((bookname == null) ? 0 : bookname.hashCode());
		result = prime * result + price;
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookVO other = (BookVO) obj;
		if (bookid != other.bookid)
			return false;
		if (bookname == null) {
			if (other.bookname != null)
				return false;
		} else if (!bookname.equals(other.bookname))
			return false;
		if (price != other.price)
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		return true;
	}
	
}
