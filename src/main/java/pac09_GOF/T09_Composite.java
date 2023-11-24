package pac09_GOF;

import java.util.ArrayList;
import java.util.List;
/**
 * @program: Java_2019.06.10
 * @author: TFC
 * @date: 2019-09-08 19:51
 * @note: ���ģʽ��ģ��ɱ���������
 *
 * *1.�Ѳ��ֺ������ϵ�á� ���νṹ ������ʾ��ʹ�ͻ��˿�����ͳһ�ķ�ʽ
 *    �����ֶ����������
 *
 *  ��ɫ���ࣺ
 *  1.���󹹼�(Component)          //����Ҷ�Ӻ�������ͬ��
 *  2.Ҷ��(Leaf)                   //���ӽڵ�
 *  3.����(���Ƹ��ڵ�)(Composite)  //���������������ɰ����ӽڵ�
 *
 *  ʵ��Ӧ�ã�
 *  1.ϵͳ��Դ������
 *  2.GUI�������ͼ
 *  3.Junit��Ԫ���Կ��
 *  4.XML����
 *  5.ɱ���������
 **/
public class T09_Composite {

    public static void main(String[] args) {
        AbstractFile pic1,pic2,pic3,vid1,vid2,vid3;
        Folder folder1,folder2,folder3;
        folder1=new Folder("�ҵ��ղ�");
        folder2=new Folder("�ҵ�ͼƬ");
        folder3=new Folder("�ҵ���Ƶ");

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

//1.���󹹼�
interface AbstractFile { void killVirus();}

//2.Ҷ��(�ӽڵ�)
class ImageFile implements AbstractFile{
    private String name;

    ImageFile(String name) {
        this.name = name;
    }
    @Override
    public void killVirus() {
        System.out.println(" ��ɱͼƬ:"+name);
    }
}
class TextFile  implements AbstractFile{
    private String name;

    public TextFile(String name) {
        this.name = name;
    }
    @Override
    public void killVirus() {
        System.out.println(" ��ɱ�ı�:"+name);
    }
}
class VideoFile implements AbstractFile{
    private String name;

    public VideoFile(String name) {
        this.name = name;
    }
    @Override
    public void killVirus() {
        System.out.println(" ��ɱ��Ƶ:"+name);
    }
}

//3.����(���ڵ�)
class Folder implements AbstractFile {
    private String name;
    private List<AbstractFile> list= new ArrayList<>();

    Folder(String name) { this.name = name; }

    public void add(AbstractFile file) { list.add(file); }
    public void remove(AbstractFile file) { list.remove(file); }
    public AbstractFile getChild(int index) { return list.get(index); }

    @Override
    public void killVirus() {
        System.out.println("*��ɱ�ļ���:"+name+"*");
        for (AbstractFile file : list)
            file.killVirus();
    }
}