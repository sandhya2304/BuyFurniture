$(function(){
	
	//solving the active menu problem
	switch(menu){
	
	case  'About Us':
	  $('#about').addClass('active');
	  break;
	  
	case  'Contact Us':
		  $('#contact').addClass('active');
		  break;
		  
	case  'All Products':
		  $('#listProducts').addClass('active');
		  break;
	case  'Manage Products':
		  $('#manageProducts').addClass('active');
		  break;
		  
	default:
		if(menu=='home') break;
		  $('#listProducts').addClass('active');
	      $('#a_'+menu).addClass('active');
		  break;
	
	}
	/*********************************************************************************************/
	
	//code for Jquery datatable
	
	var $table = $('#productListTable');
	
	//execute the code only where we have this table
	
	if($table.length)
		{
		 
		   //console.log('Inside the Table');
		
		var jsonURL = '';
		
		if(window.categoryId=='')
			{
			   jsonURL = window.contextRoot + '/json/data/all/products';
			}
		else
			{
			 jsonURL = window.contextRoot + '/json/data/category/'+window.categoryId+'/products';
			}
		
		  $table.DataTable({
			
			  lengthMenu : [[3,5,10,-1],['3 Records','5 Records','10 Records','ALL']],
			  pageLength : 5,
			  ajax : {
				  url: jsonURL,
				  dataSrc : ''
				  
			  },
			  columns : [
				  {
					data : 'code',
					  mRender : function(data,type,row){
						  
						  return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg" />';
					  }
						
				  },
				  {
					  data : 'name'
				  },
				  {
					  data : 'brand'
				  },
				  {
					  data : 'unitPrice',
					  mRender : function(data,type,row){
						  return '&#8377; ' + data
					  }
				  },
				  {
					  data : 'quantity',
					  mRender : function(data,type,row){
						  
						  if(data < 1)
							  {
							      return '<span style="color:red">Out Of Stock!!</span>';
							  }
						  
						  return data;
					  }
				  },
				  {
					  data : 'id',
					  bSortable: false,
					  mRender : function(data,type,row){
						  
						  var str = '';
						  str += '<a href="'+window.contextRoot+ '/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &nbsp;';
						  
						  if(row.quantity < 1)
							  {
							  str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
							  }
						  else
							  {
							  str += '<a href="'+window.contextRoot+ '/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
							  }
						  
						   return str;
						  
					  }
					  
				  }
				  
				  
			  ]
			  
		  });
		
		}
	/*********************************************************************************************************/
	
	
	//dismissing the alert after 3 seconds
	
	var $alert = $('.alert');
	
	if($alert.length)
	  {
		
		  setTimeout(function(){
			  
			  $alert.fadeOut('slow');
			  
		  },3000)
		
		
	  }
	/*************************bootbox plugin for toggle switch************************************/
	
	$('.switch input[type="checkbox"]').on('change',function(){
		
		var checkbox = $(this);
		var checked = checkbox.prop('checked');
		var dMsg = (checked)? 'You want to activate the product?' : 'You want to deactivate the product?';
		
		var value = checkbox.prop('value'); 
		
		bootbox.confirm({
		
			size : 'medium', 
			title : 'Product Activation and Deactivation',
			message : dMsg,
			callback : function(confirmed){
				
				if(confirmed){
					
					console.log(value);
					bootbox.alert({
						size : 'medium', 
						title : 'information',
						message : 'You are going to perform operation on :'+ value				
					});				
				}
				else
					{
					  checkbox.prop('checked',!checked);
					}			
			}
		});
		
	})
	
	
	/**********************************************************************/

	///////////////////////////////////////////////////////////////////////////////////////////////////////////
});
