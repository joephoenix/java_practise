package phoenix.collect;

/**
 * 
 * 逻辑判断题目，按照条件推论出谁养鱼，
 * 
 * 详见说明文档WhoFeedFish.html
 * 
 * 
 * @author chenxianxun
 *
 */
public class WhoFeedFish {

	public class CCDCP {
		String contry;
		String colour;
		String drinks;
		String cigret;
		String petget;

		CCDCP(String ct, String cl, String dk, String cg, String pg) {
			this.contry = ct;
			this.colour = cl;
			this.drinks = dk;
			this.cigret = cg;
			this.petget = pg;
		}
	}

	public static void main(String args[]) {

		// 第一行是国家，第二行是颜色，第三行饮料，第四行是香烟，第五行是宠物
		String wff[][] = new String[5][5];
		// 8.中间的屋主喝牛奶，9.挪威人住第一间，14.挪威人住在蓝色房子隔壁
		wff[2][2] = "milk";
		wff[0][0] = "Noway";
		wff[2][1] = "Blue";
		// （1）英国人住在红色房屋里；(2)瑞典人养了一只狗,(3)丹麦人喝茶,
		// (4).绿色房屋的屋主喝咖啡,(5)黄色屋主吸Dunhill香烟,(12)吸BlueMaster香烟的屋主喝啤酒
		// (13)德国人吸Prince香烟

	}
}
