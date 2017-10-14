<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="StyleSheet" href="../css/dtree.css" type="text/css" />
	<script type="text/javascript" src="../js/dtree.js"></script>
</head>



<body>

<h1><a href="/">Destroydrop</a> &raquo; <a href="/javascripts/">Javascripts</a> &raquo; <a href="/javascripts/tree/">Tree</a></h1>

<h2>Example</h2>

<div class="dtree">

	<p><a href="javascript: d.openAll();">open all</a> | <a href="javascript: d.closeAll();">close all</a></p>

	<script type="text/javascript">
		<!--

		d = new dTree('d');
             //  父目录    名字     
		d.add(0,-1,'一级目录');
        //目录位置    父目录节点  节点显示名称           点击链接
		d.add(1,0,'系统菜单','https://www.baidu.com/index.php?tn=monline_5_dg');
		d.add(2,0,'系统设置','https://www.baidu.com/index.php?tn=monline_5_dg');
		d.add(3,1,'Node 1.1','https://www.baidu.com/index.php?tn=monline_5_dg');
		d.add(4,0,'商品菜单','https://www.baidu.com/index.php?tn=monline_5_dg');
		d.add(5,3,'Node 1.1.1','https://www.baidu.com/index.php?tn=monline_5_dg');
		d.add(6,5,'Node 1.1.1.1','https://www.baidu.com/index.php?tn=monline_5_dg');
		d.add(7,0,'Node 4','https://www.baidu.com/index.php?tn=monline_5_dg');
		d.add(8,1,'Node 1.2','https://www.baidu.com/index.php?tn=monline_5_dg');
		d.add(9,0,'My Pictures','https://www.baidu.com/index.php?tn=monline_5_dg','Pictures I\'ve taken over the years','','','img/imgfolder.gif');
		d.add(10,9,'The trip to Iceland','https://www.baidu.com/index.php?tn=monline_5_dg','Pictures of Gullfoss and Geysir');
		d.add(11,9,'Mom\'s birthday','https://www.baidu.com/index.php?tn=monline_5_dg');
		d.add(12,0,'Recycle Bin','https://www.baidu.com/index.php?tn=monline_5_dg','','','img/trash.gif');

		document.write(d);

		//-->
	</script>

</div>

<p><a href="mailto&#58;drop&#64;destroydrop&#46;com">&copy;2002-2003 Geir Landr&ouml;</a></p>

</body>

</html>