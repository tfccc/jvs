package pac09_GOF;

import java.util.ArrayList;
import java.util.List;
/**
 * @program: Java_2019.06.10
 * @author: TFC
 * @date: 2019-09-08 19:51
 * @note: 组合模式：模拟杀毒软件工作
 *
 * *1.把部分和整体关系用“ 树形结构 ”来表示，使客户端可以用统一的方式
 *    处理部分对象、整体对象。
 *
 *  角色分类：
 *  1.抽象构件(Component)          //定义叶子和容器共同点
 *  2.叶子(Leaf)                   //无子节点
 *  3.容器(类似父节点)(Composite)  //具有容器特征，可包含子节点
 *
 *  实际应用：
 *  1.系统资源管理器
 *  2.GUI容器层次图
 *  3.Junit单元测试框架
 *  4.XML解析
 *  5.杀毒软件工作
 **/
public class T09_Composite {

    public static void main(String[] args) {
        AbstractFile pic1,pic2,pic3,vid1,vid2,vid3;
        Folder folder1,folder2,folder3;
        folder1=new Folder("我的收藏");
        folder2=new Folder("我的图片");
        folder3=new Folder("我的视频");

        pic1  = new ImageFile("pic1");
        pic2  = new ImageFile("pic2");
        pic3  = new ImageFile("pic3");
        vid1  = new VideoFile("vid1");
        vid2  = new VideoFile("vid2");
        vid3  = new VideoFile("vid3");

        folder1.add(folder2); folder1.add(folder3);
        folder2.add(pic1); folder3.add(vid1);
        folder2.add(pic2); folder3.add(vid2);
        folder2.add(pic3); folder3.add(vid3);

        folder1.killVirus();
    }
}

//1.抽象构件
interface AbstractFile { void killVirus();}

//2.叶子(子节点)
class ImageFile implements AbstractFile{
    private String name;

    ImageFile(String name) {
        this.name = name;
    }
    @Override
    public void killVirus() {
        System.out.println(" 查杀图片:"+name);
    }
}
class TextFile  implements AbstractFile{
    private String name;

    public TextFile(String name) {
        this.name = name;
    }
    @Override
    public void killVirus() {
        System.out.println(" 查杀文本:"+name);
    }
}
class VideoFile implements AbstractFile{
    private String name;

    public VideoFile(String name) {
        this.name = name;
    }
    @Override
    public void killVirus() {
        System.out.println(" 查杀视频:"+name);
    }
}

//3.容器(父节点)
class Folder implements AbstractFile {
    private String name;
    private List<AbstractFile> list= new ArrayList<>();

    Folder(String name) { this.name = name; }

    public void add(AbstractFile file) { list.add(file); }
    public void remove(AbstractFile file) { list.remove(file); }
    public AbstractFile getChild(int index) { return list.get(index); }

    @Override
    public void killVirus() {
        System.out.println("*查杀文件夹:"+name+"*");
        for (AbstractFile file : list)
            file.killVirus();
    }
}