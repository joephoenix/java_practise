package phoenix.patterns;

import phoenix.patterns.p21ResponsibilityChain.RespnosiblityChain;

public class ChainTest {

	public static void main(String[] args) {
		// 责任链模式测试
		RespnosiblityChain rc = new RespnosiblityChain();
		rc.chainProccess();
	}
}
