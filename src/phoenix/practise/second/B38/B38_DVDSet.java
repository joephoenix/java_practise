package phoenix.practise.second.B38;

public class B38_DVDSet {

	String names[] = new String[50];
	int state[] = new int[50];

	public void initial() {
		/** DVD1 罗马假日 */
		names[0] = "罗马假日";
		state[0] = 1;

		/** DVD2 基督山伯爵 */
		names[1] = "基督山伯爵";
		state[1] = 0;

		/** DVD3银河漫游指南 */
		names[2] = "银河漫游指南";
		state[2] = 0;

		/** DVD4 星际之门 */
		names[3] = "星际之门";
		state[3] = 0;
		
		/** DVD5   霍比特人 */
		names[4] = "霍比特人";
		state[4] = 0;

	}
}
