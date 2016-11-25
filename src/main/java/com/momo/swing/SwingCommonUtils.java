package com.momo.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Window;

import javax.swing.UIManager;

import com.momo.util.CommonUtils;

public class SwingCommonUtils {

	/**
	 * 根据系统设置窗口
	 * 
	 * @param window
	 *            要更改的窗口大小
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void setBounds(Window window, int x, int y, int width, int height) {
		String osName = CommonUtils.getOsName();
		if (osName.contains("window")) {
			window.setBounds(x, y, width + 50, height + 50);
		} else {
			window.setBounds(x, y, width, height);
		}
	}

	/**
	 * 设置默认字体
	 * 
	 * @param name
	 *            字体名称
	 * @param style
	 *            字体风格
	 * @param size
	 *            字体大小（可根据不同内容设置不同大小）
	 */
	public static void setFont(String name, int style, int size) {
		if (size <= 5) {
			size = 5;
		}
		UIManager.put("List.font", new Font(name, style, size));
		UIManager.put("TableHeader.font", new Font(name, style, size));
		UIManager.put("Panel.font", new Font(name, style, size));
		UIManager.put("TextArea.font", new Font(name, style, size));
		UIManager.put("ToggleButton.font", new Font(name, style, size));
		UIManager.put("ComboBox.font", new Font(name, style, size));
		UIManager.put("ScrollPane.font", new Font(name, style, size));
		UIManager.put("Spinner.font", new Font(name, style, size));
		UIManager.put("RadioButtonMenuItem.font", new Font(name, style, size));
		UIManager.put("Slider.font", new Font(name, style, size));
		UIManager.put("EditorPane.font", new Font(name, style, size));
		UIManager.put("OptionPane.font", new Font(name, style, size));
		UIManager.put("ToolBar.font", new Font(name, style, size));
		UIManager.put("Tree.font", new Font(name, style, size));
		UIManager.put("CheckBoxMenuItem.font", new Font(name, style, size));
		UIManager.put("TitledBorder.font", new Font(name, style, size));
		UIManager.put("Table.font", new Font(name, style, size));
		UIManager.put("MenuBar.font", new Font(name, style, size));
		UIManager.put("PopupMenu.font", new Font(name, style, size));
		UIManager.put("DesktopIcon.font", new Font(name, style, size));
		UIManager.put("Label.font", new Font(name, style, size));
		UIManager.put("MenuItem.font", new Font(name, style, size));
		UIManager.put("TextField.font", new Font(name, style, size));
		UIManager.put("TextPane.font", new Font(name, style, size));
		UIManager.put("CheckBox.font", new Font(name, style, size));
		UIManager.put("ProgressBar.font", new Font(name, style, size));
		UIManager.put("FormattedTextField.font", new Font(name, style, size));
		UIManager.put("ColorChooser.font", new Font(name, style, size));
		UIManager.put("Menu.font", new Font(name, style, size));
		UIManager.put("PasswordField.font", new Font(name, style, size));
		UIManager.put("Viewport.font", new Font(name, style, size));
		UIManager.put("TabbedPane.font", new Font(name, style, size));
		UIManager.put("RadioButton.font", new Font(name, style, size));
		UIManager.put("ToolTip.font", new Font(name, style, size));
		UIManager.put("Button.font", new Font(name, style, size));
	}

	/**
	 * 设置组件基本风格
	 * 
	 * @param component 任意组件
	 * @param backColor 设置背景色
	 * @param foreColor 设置前景色
	 * @param font 设置字体
	 */
	public void setControlStyle(Component component, Color backColor, Color foreColor, Font font) {
		if(backColor!=null){
			component.setBackground(backColor);
		}
		if(foreColor!=null){
			component.setForeground(foreColor);
		}
		if(font!=null){
			component.setFont(font);
		}
	}

	public static void main(String[] args) {
		setFont("微软雅黑", 1, 1);
	}
}
