package implementations;

import interfaces.AbstractTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tree<E> implements AbstractTree<E> {
    E key;
    Tree<E> parent;
    List<Tree<E>> children;
    public Tree(E key,Tree<E>... children) {
        this.key=key;
        this.children=new ArrayList<>();
        for(Tree<E> child:children){
            this.children.add(child);
            child.parent=this;
        }


    }
    public Tree(E key,List<Tree<E>> children) {
        this.key=key;
        this.children=children;



    }

    @Override
    public List<E> orderBfs() {
        List<E> list=new ArrayList<>();
        ArrayDeque<Tree<E>> queue=new ArrayDeque<>();
        queue.offer(this);
        while(!queue.isEmpty()){
            Tree<E> current=queue.poll();
            list.add(current.key);
            for(Tree<E> tree: current.children){
                queue.offer(tree);
            }
        }
        return list;
    }

    @Override
    public List<E> orderDfs() {
        List<E> list=new ArrayList<>();
        dfs(list,this);
        return list;
    }
    public void dfs(List<E> list,Tree<E> tree){
        for(Tree<E> cur:tree.children){

            dfs(list,cur);
        }
        list.add(tree.key);
    }
public void dfsAdd(E parentKey,Tree<E> child,Tree<E> tree){
        for(Tree<E> cur:tree.children){
            if(cur.key.equals(parentKey)){
                cur.children.add(child);
                break;
            }
                else{
                dfsAdd(parentKey, child, cur);
            }
        }

    }

    @Override
    public void addChild(E parentKey, Tree<E> child) {
dfsAdd(parentKey,child,this);
    }

    public void dfsRemove(E nodeKey,Tree<E> tree){
        for(Tree<E> cur:tree.children){
            if(cur.key.equals(nodeKey)){
                tree.children.remove(cur);
                break;
            }
            else{
                dfsRemove(nodeKey,cur);
            }
        }

    }
	@Override
    public void removeNode(E nodeKey) {
        dfsRemove(nodeKey,this);

    }
    public Tree<E> dfsSearch(Tree<E> tree,E key){
        for(Tree<E> cur:tree.children){
        if(cur.key.equals(key)){
            return cur;
        }
        else {
            dfsSearch(cur,key);
        }
        }
        return null;

    }

    @Override
    public void swap(E firstKey, E secondKey) {
Tree<E> firstTree=dfsSearch(this,firstKey);
Tree<E> secondTree=dfsSearch(this,secondKey);
if(firstTree==null||secondTree==null){
    throw new IllegalArgumentException();
}
Tree<E> help= new Tree<>(firstTree.key,firstTree.children);
List<Tree<E>> list1=new ArrayList<>();
for(Tree<E> cur:secondTree.children){
    list1.add(cur);
}
firstTree.key=secondTree.key;
firstTree.children=list1;
        List<Tree<E>> list2=new ArrayList<>();
        for(Tree<E> cur:help.children){
            list2.add(cur);
        }
secondTree.key=help.key;
        secondTree.children=list2;
    }
}




