package com.tasty.view.qna;

import java.util.List;

import com.tasty.qna.model.Qna;

public class PrintQna {

	public void printList(Object obj) {
		List<Qna> list = (List<Qna>)obj;
		for(Qna qna : list)
			System.out.println(qna);
	}

}
