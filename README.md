[![](https://jitpack.io/v/Mrxxy/RatioImageView.svg)](https://jitpack.io/#Mrxxy/RatioImageView)
## RatioImageView
根据比例自动计算宽高的ImageView

1. 宽度为固定值或者`match_parent`时,会忽略高度设定值,直接根据宽高比重新计算高度,即**高度有值时,优先使用高度作为基础值进行比例计算**
2. 宽度为`wrap_content`时,若此时高度为指定值,会根据宽高比重新计算宽度
3. 以上两点成立条件为**代码或布局中指定宽高比**

## Download
### Step1
在项目级build.gradle文件添加
```
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```
### Step2
```
implementation 'com.github.Mrxxy:RatioImageView:1.0.2'
```

## Usage

### Step1
在xml布局中直接使用
1. 直接设置宽高比比值
```xml
<mrxxy.github.ratioimageview.RatioImageView
      android:src="#522567"
      app:ratio="1"
      android:padding="10dp"
      android:layout_width="100dp"
      android:layout_height="wrap_content"/>
```
2. 设置宽高比例值
```xml
<mrxxy.github.ratioimageview.RatioImageView
      android:src="#522567"
      app:ratio_w="4"
      app:ratio_h="3"
      android:layout_margin="10dp"
      android:layout_width="wrap_content"
      android:layout_height="100dp"/>
```
3. 代码中设置宽高比
```xml
<mrxxy.github.ratioimageview.RatioImageView
      android:id="@+id/ratio_image"
      android:background="#522567"
      android:layout_margin="10dp"
      android:layout_width="match_parent"
      android:layout_height="wrap_content"/>
```
```java
RatioImageView ratioImageView = findViewById(R.id.ratio_image);
ratioImageView.setRatio(16 / 9.0f);
// or
ratioImageView.setRatio(16, 9);
```

## Preview/预览:
![preview_1](https://github.com/Mrxxy/RatioImageView/blob/master/art/screenshot_01.png)