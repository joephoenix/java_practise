package phoenix.practise.third.C10;

/**
 * 该类为消息类，
 * 
 * 只有一个整型的id变量和一个String类型的content
 * 
 * @author joephoenix
 * 
 */
public class Message {
	public static int id;
	public String content;

	/**
	 * 返回content的值
	 * 
	 * @return
	 */
	public String getContent() {
		return content;
	}

	// 设置content的值
	public void setContent(String content) {
		this.content = content;
	}

	// 获取id的值
	public int getId() {
		return id;
	}

	// 设置id的值
	public void setId(int id) {
		Message.id = id;
	}
}
