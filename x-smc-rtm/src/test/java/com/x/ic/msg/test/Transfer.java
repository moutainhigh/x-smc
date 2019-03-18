package com.x.ic.msg.test;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.hadoop.hbase.util.Hash;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.MapFunction;
import com.jayway.jsonpath.ReadContext;
import com.jayway.jsonpath.internal.JsonContext;
import com.x.ic.msg.constants.SmcCacheConstant;
import com.x.ic.smc.sdk.cache.util.SmcCacheUtil;
import com.x.ic.smc.sdk.cache.vo.Node;
import com.x.ic.smc.sdk.cache.vo.NodeElementMapping;
import com.x.sdk.ccs.util.ConfigTool;
import com.x.sdk.mcs.MCSClientFactory;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONUtil;
import net.minidev.json.parser.JSONParser;


public class Transfer {

	public static void main(String[] args) throws IOException {
		List<Node> nodes = SmcCacheUtil.getNodeByContractId("pubgo", "mayt3-test-topic");
		List<NodeElementMapping> mapping = SmcCacheUtil.getNodeElementMappingByPolicyId("pubgo", 100001l);

		DocumentContext context =  JsonPath.parse(new File("F:/jsonData/data.json"));
//		DocumentContext test =  JsonPath.parse(new File("F:/jsonData/test.json"));
		String nodeTreeStr = MCSClientFactory.getCacheClient(SmcCacheConstant.MSDNS).hget(SmcCacheConstant.NameSpace.NODE_CACHE, "nodeTree");
		
		NodeTree tree = JSONObject.parseObject(nodeTreeStr, NodeTree.class);


		for(Node node:nodes){
			if(!node.getNodeType().equals("7")&&!node.getNodeType().equals("8")){
				Object o = context.read(node.getNodePath());
				System.out.println(context.read(node.getNodePath()).toString());
				
				System.out.println(o.getClass().getName());
			}
		}
		
		
		
//		Map<String,String> map = new HashMap<>();
//		Map<Integer, Map<String,String>> arrMap = new HashMap<>();
//		List<Map> newList = new ArrayList<>();
//		ts(context,tree,newList);
//		for(Map mapTmp:newList){
//		System.out.println(mapTmp);
//		}
//		boolean flag = false;
//		Node cycleNode = null;
//		for (NodeElementMapping m : mapping) {
//			Long nodeId = m.getSrcNodeDescId();
//			
//			ts5(tree,nodeId);
//			
//			for(Node node : nodes){
//				if(node.getNodeId() == nodeId&&node.getNodeType().equals("8")){
//					flag = true;
//					cycleNode=node;
//				}
//				
//			}
//		}
//
//		if(flag){
//			map = new HashMap();
//			
//			List list = context.read(cycleNode.getNodePath());
//			
//			
//		}
//		List<Map<Long, String>> list = new ArrayList<>();
//		ts3(context, nodes,list);
		
	}
	
	
//	public static void ts5(NodeTree tree,Long nodeId){
//		if(tree.getNodeId()==nodeId){
//			
//		}else{
//			
//		}
//	}
//	
	
	
	
	
	
	
	
	
	
	
	public static StringBuffer ts7 (NodeTree tree,StringBuffer path){
		
		if(tree!=null){
			path.insert(0, tree.getNodeCode()).insert(0, '.');
			ts7(tree.getParentNode(),path);
		}
		return path;
	}
	
	
	
	
	
	
	
	
	public static void ts3(ReadContext context,List<Node> nodes,List<Map<Long, String>> list){
		for(Node node : nodes){
			if(node.getNodePath().matches("\\*")){
				System.out.println(node.getNodePath());
			}

		}
	}
//	public static void ts2(Object object,List<Node> nodes){
//		
//		
//		
//		
//		
//		
//		
//		if(object instanceof Map){
//			Map m = (Map)object;
//			for(Object key : m.keySet()){
//				StringBuffer tmpBuf = new StringBuffer();
//				tmpBuf.append(buf);
//				tmpBuf.append(".").append(key);
//				if(m.get(key) instanceof Map|| m  instanceof List){
//					ts2(m.get(key),tmpBuf,nodes);
//				}else{
//					
//				}
//			}
//		}else if(object instanceof List){
//			List list = (List)object;
//			for (int i  = 0; i < list.size(); i++) {
//				StringBuffer tmpBuf2 = new StringBuffer();
//				tmpBuf2.append(buf);
//				tmpBuf2.append("[").append(i).append("]");
//				ts2(list.get(i),tmpBuf2,nodes);
//			}
//		}else{
//			System.out.println(buf.toString() + "==>" + object);
//			buf.setLength(6);
//		}
//	}
	
	public static void ts3(ReadContext context,NodeTree tree){
		
		
		
	}
	
	public static void ts(ReadContext context,NodeTree tree,List list){
		Map<Long,Map<String,String>> map=null;
		Map<Long,String> topMap = new HashMap<>();
		if(tree.getNodeType().equals("7")){
			JSONArray array = context.read(tree.getNodePath());
			List<NodeTree> childs = tree.getChildNodes();
			for (int i = 0 ; i < array.size(); i ++) {
				Map<Long, String> tmp = new HashMap<>();
				for (NodeTree nodeTree : childs) {
					String path = nodeTree.getNodePath();
					String newPath = path.replace(tree.getNodePath()+"[*]", tree.getNodePath()+"["+ i +"]");
					NodeTree tmpNode = nodeTree.clone();
					tmpNode.setNodePath(newPath);
					ts(context,tmpNode,list);
				}
			}
		}else if(tree.getNodeType().equals("8")){
			
			List<NodeTree> childs = tree.getChildNodes();
		
			for (NodeTree nodeTree : childs) {
				ts(context,nodeTree,list);
			}	
		}else{
			Map<String,String> mapTmp=new HashMap();
			mapTmp.put(tree.getNodePath(),context.read(tree.getNodePath()).toString());
			map=new HashMap();
			map.put(tree.getNodeId(),mapTmp);
		}
		list.add(map);
	}
	public static boolean isHostConnectable(String host, int port) {
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(host, port));
        } catch (IOException e) {
            return false;
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }


}
