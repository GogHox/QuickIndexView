# QuickIndexView
一个Android快速索引自定义控件

![截图](https://github.com/GogHox/QuickIndexView/blob/master/pic.png)

### 用法
直接当做一个控件来使用即可。

提供了如下接口：
``` java
    /**
     * 当点击字母时的监听事件
     * @param listener
     */
    public void setOnLetterSelectListener(OnLetterSelectListener listener)
    /**
     * 设置显示的字母（即右边显示的字母）
     * @param letters
     */
    public void setLetters(String[] letters)
    public void setBackgroundColor(String color)
    public void setTextColor(String color)
```
