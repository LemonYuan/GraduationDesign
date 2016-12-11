<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
    <!-- 引入 echarts.js -->
    <script src="js/echarts.min.js"></script>
    <script src="js/jquery-3.1.1.min.js"></script>
</head>
<body>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="width: 600px;height:400px;""></div>
    <button id="barCharButton" >acquire bar chart</button>
    
    <script type="text/javascript">

        $("#barCharButton").click(function(){
		     
        	 $.ajax({
   			  url: "http://localhost:8080/mybatis/customer/customerNumByStore",
   			  dataType:"JSON",
   			  data:"",
   			  success: function(result){
   				   if(result){
   					   alert(result)
   				    var myChart = echarts.init(document.getElementById('main'));
   				    var option = {
   				        title: {
   				            text: 'bar chart'
   				        },
   				        tooltip: {},
   				        legend: {
   				            data:"quantities"
   				        },
   				        xAxis: {
   				            data:result.categories
   				        },
   				        yAxis: {},
   				        series: [{
   				            name: 'quantities',
   				            type: 'bar',
   				            data: result.data
   				        }]
   				    };
   				    myChart.setOption(option);
   				   }
   				   else{
   					   alert("error in result")
   				   }
   		      },
   		    error: function(){
   		    	alert("error in com")
   			  }
   		  });
        })
        
    </script>
</body>
</html>