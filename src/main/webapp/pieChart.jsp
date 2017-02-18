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
    <div id="main" style="width: 600px;height:600px;""></div>
    <button id="pieCharButton" >产品数量分类图</button>
    
    <script type="text/javascript">

        	
            $("#pieCharButton").click(function(){
   		     
           	 $.ajax({
      			  url: "http://localhost:8080/mybatis/film/getFilmsByCategory",
      			  dataType:"JSON",
      			  data:"",
      			  success: function(result){
      				   if(result){
      					   alert(result)
      	   				    var myChart = echarts.init(document.getElementById('main'));
      	   				      option = {
      	   					    backgroundColor: '#2c343c',

      	   					    title: {
      	   					        text: 'Customized Pie',
      	   					        left: 'center',
      	   					        top: 20,
      	   					        textStyle: {
      	   					            color: '#ccc'
      	   					        }
      	   					    },

      	   					    tooltip : {
      	   					        trigger: 'item',
      	   					        formatter: "{a} <br/>{b} : {c} ({d}%)"
      	   					    },

      	   					    visualMap: {
      	   					        show: false,
      	   					        min: 80,
      	   					        max: 600,
      	   					        inRange: {
      	   					            colorLightness: [1, 1]
      	   					        }
      	   					    },
      	   					    series : [
      	   					        {
      	   					            name:'访问来源',
      	   					            type:'pie',
      	   					            radius : '55%',
      	   					            center: ['50%', '50%'],
      	   					            data:result.data.sort(function (a, b) { return a.value - b.value}),
      	   					            roseType: 'angle',
      	   					            label: {
      	   					                normal: {
      	   					                    textStyle: {
      	   					                        color: 'rgba(255, 255, 255, 0.3)'
      	   					                    }
      	   					                }
      	   					            },
      	   					            labelLine: {
      	   					                normal: {
      	   					                    lineStyle: {
      	   					                        color: 'rgba(255, 255, 255, 0.3)'
      	   					                    },
      	   					                    smooth: 0.2,
      	   					                    length: 10,
      	   					                    length2: 20
      	   					                }
      	   					            },
      	   					            itemStyle: {
      	   					                normal: {
      	   					                    color: '#c23531',
      	   					                    shadowBlur: 200,
      	   					                    shadowColor: 'rgba(0, 0, 0, 0.5)'
      	   					                }
      	   					            }
      	   					        }
      	   					    ]
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