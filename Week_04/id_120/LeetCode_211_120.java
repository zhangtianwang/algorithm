package com.data.structure.TrieTree;


import com.data.structure.dfs.DFSDemo;

/**
 * @author zzl
 * @date 2019/5/12 21:15
 * @description
 */

public class WordDictionary {

    //根指针不存储实际的节点
    public TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        this.root=new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node=root;
        char[] charArr=word.toCharArray();
        for(int i=0;i<charArr.length;i++){

            int index = charArr[i]-'a';
            if(node.children[index]==null){
                node.children[index]=new TrieNode();
            }
            node=node.children[index];
        }
        node.isEndChar=true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode next=this.root;
        return searchWord(next,word,0);
    }

    private boolean searchWord(TrieNode next,String word,int index){
        if(index==word.length()){
            return next.isEndChar;
        }
        if(word.charAt(index)=='.'){
            //该节点的子节点只要有一个OK，就可以
            for(TrieNode node : next.children){
                if(node!=null&&searchWord(node,word,index+1)) {
                    return true;
                }
            }
            return false;
        }else{
            int pos=word.charAt(index)-'a';
            if(next.children[pos]==null){
                return false;
            }
            next = next.children[pos];
            return next!=null&&searchWord(next,word,index+1);
        }
    }

    public class TrieNode{
        public TrieNode[] children;
        private boolean isEndChar=false;
        public TrieNode(){
            children=new TrieNode[26];
        }
    }

}
