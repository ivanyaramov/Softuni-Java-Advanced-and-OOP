package implementations;

import interfaces.AbstractTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Tree<E> implements AbstractTree<E> {
    private E key;
    private Tree<E> parent;
    private List<Tree<E>> children;
    int[] help={-1};

    public Tree(E key){
        this.key=key;
        this.children=new ArrayList<>();
    }
    @Override
    public void setParent(Tree<E> parent) {
this.parent=parent;

    }

    @Override
    public void addChild(Tree<E> child) {
this.children.add(child);
    }

    @Override
    public Tree<E> getParent() {
        return this.parent;
    }

    @Override
    public E getKey() {
        return this.key;
    }

    @Override
    public String getAsString() {
        int a=-1;
        StringBuilder build=new StringBuilder();
        return dfs(this,build,a);
    }
public String dfs(Tree<E> tree,StringBuilder build,int a){
        a++;
     for(int i=0;i<a*2;i++){
         build.append(" ");
     }
     build.append(tree.getKey());
     for(Tree<E> cur:tree.children){
         build.append(System.lineSeparator());
         dfs(cur,build,a);


     }
     return build.toString();
}
    public List<E> dfsFindLeafs(Tree<E> tree,List<E> list){
        if(tree.children.isEmpty()) {
            list.add(tree.getKey());
        }
        for(Tree<E> cur:tree.children){
            dfsFindLeafs(cur,list);


        }
        return list;
    }
    @Override
    public List<E> getLeafKeys() {
        List<E> list=new ArrayList<>();
        return dfsFindLeafs(this,list);
    }
    public List<E> dfsFindMids(Tree<E> tree,List<E> list){
        if(!tree.children.isEmpty()&&tree.getParent()!=null) {
            list.add(tree.getKey());
        }
        for(Tree<E> cur:tree.children){
            dfsFindMids(cur,list);


        }
        return list;
    }
    @Override
    public List<E> getMiddleKeys() {
        List<E> list=new ArrayList<>();
        return dfsFindMids(this,list);
    }

    @Override
    public Tree<E> getDeepestLeftmostNode() {
        List<Tree<E>> listrandom=new ArrayList<>();
        List<List<Tree<E>>> list=new ArrayList<>();
        list=dfsDeepest(this,listrandom,list);
        int max=0;
        List<Tree<E>> finalList= new ArrayList<>();
        for(List<Tree<E>> cur:list){
            if(cur.size()>max){
                max=cur.size();
                finalList=cur;
            }
        }


        return finalList.get(finalList.size()-1);
    }
    public List<List<Tree<E>>> dfsDeepest(Tree<E> tree,List<Tree<E>> list,List<List<Tree<E>>> listTotal){
        if(tree.getParent()==null){
            list.add(tree);
        }
        if(tree.children.isEmpty()) {
            listTotal.add(list);
        }

        for(Tree<E> cur:tree.children){
            List<Tree<E>> list1=copyListTree(list);
            list1.add(cur);

            dfsDeepest(cur,list1,listTotal);


        }
        return listTotal;
    }
    public List<Tree<E>> copyListTree(List<Tree<E>> list){
        List<Tree<E>> newList=new ArrayList<>();
        for(Tree<E> cur:list){
            newList.add(cur);
        }
        return newList;
    }

    @Override
    public List<E> getLongestPath() {
        List<E> randomlist=new ArrayList<>();
        List<List<E>> list=new ArrayList<>();
                list=dfsLongestPath(this,randomlist,list);
        int max=0;
        List<E> finalList= new ArrayList<>();
        for(List<E> cur:list){
            if(cur.size()>max){
                max=cur.size();
                finalList=cur;
            }
        }
        return finalList;
    }
    public List<List<E>> dfsLongestPath(Tree<E> tree,List<E> list,List<List<E>> listTotal){
if(tree.getParent()==null){
    list.add(tree.getKey());
}
        if(tree.children.isEmpty()) {
            listTotal.add(list);
        }

        for(Tree<E> cur:tree.children){
            List<E> list1=copyList(list);
            list1.add(cur.getKey());

            dfsLongestPath(cur,list1,listTotal);


        }
        return listTotal;
    }
    public List<E> copyList(List<E> list){
        List<E> newList=new ArrayList<>();
        for(E cur:list){
            newList.add(cur);
        }
        return newList;
    }
    @Override
    public List<List<E>> pathsWithGivenSum(int sum) {
        List<List<E>> total=new ArrayList<>();
        List<E> randomlist=new ArrayList<>();
        List<List<E>> list=new ArrayList<>();
        list=dfsLongestPath(this,randomlist,list);
        for(List<E> cur:list){
            if(sumElements(cur)==sum){
                total.add(cur);
            }
        }
return total;
    }
    int sumElements(List<E>list){
        int sum=0;
        for(E cur:list){
            sum+=(int) cur;
        }
return sum;
    }

    @Override
    public List<Tree<E>> subTreesWithGivenSum(int sum) {
        List<Tree<E>> list=new ArrayList<>();
        list=dfsSubtrees(this,sum,list);
        return list;
    }
    public List<Tree<E>> dfsSubtrees(Tree<E>tree,int sum,List<Tree<E>> list){
        boolean bool=true;
        int sumHere=0;
        sumHere+=(int)tree.getKey();
        for(Tree<E> cur:tree.children){
            if(!cur.children.isEmpty()){
                bool=false;
            }
            sumHere+=(int)cur.getKey();
            dfsSubtrees(cur,sum,list);
        }
        if(bool&sumHere==sum){
            list.add(tree);
        }
        return list;
    }
}



