package com.ktdsuniversity.edu.functional.anonymous;

/**
 * 버튼, 테이블(표), 이미지, 텍스트 등등
 */
public class UI {

	public void click(ClickEventListener clickEventListener) {
		clickEventListener.click();
	}
	
	public void doubleClick(DoubleClickEventListener doubleClickEventLister) {
		doubleClickEventLister.doubleClick();
	}
	
	public void dragAndDrop(DragAndDropEventListener dragAndDropEventListener) {
		dragAndDropEventListener.dragAndDrop();
	}
	
	public void wheel(WheelEventListener wheelEventListener) {
		wheelEventListener.wheel();
	}
	
}
