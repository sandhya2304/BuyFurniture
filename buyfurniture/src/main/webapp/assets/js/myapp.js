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
	case  'User Cart':
		  $('#userCart').addClass('active');
		  break;
		  
	default:
		if(menu=='home') break;
		  $('#listProducts').addClass('active');
	      $('#a_'+menu).addClass('active');
		  break;
	
	}
	/*********************************************************************************************/
	//to tackle csrf token
	
	// for handling CSRF token
	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content');
	
	if((token!=undefined && header !=undefined) && (token.length > 0 && header.length > 0))
	{		
		
		// set the token header for the ajax request
		$(document).ajaxSend(function(e, xhr, options) {			
			xhr.setRequestHeader(header,token);			
		});				
	}
	
	
	
	/***********************************************************************************/
	//code for Jquery product datatable
	
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
   					 bSortable : false,
   					 mRender : function(data,type,row)
   					 {
   						 var str = '';
   						str +='<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160; ';
   						
   						if(userRole == 'ADMIN')
   							{
  							 str +='<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>' ;

   							}
   						else
   							{
   						
   						if(row.quantity < 1)
							{
							str +='<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
							}
   						else
   							{
   							
							 str +='<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>' ;
   								         						    							
   							}
   						
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
	
	/*****************data table for Admin***********************/
	
	var $adminProductstable = $('#adminProductsTable');
	
	//execute the code only where we have this table
	
	if($adminProductstable.length)
		{
		 
		   //console.log('Inside the Table');
		
		var jsonURL = window.contextRoot + '/json/data/admin/all/products';
		
		
		
		$adminProductstable.DataTable({
			
			  lengthMenu : [[10,30,50,-1],['10 Records','30 Records','50 Records','ALL']],
			  pageLength : 30,
			  ajax : {
				  url: jsonURL,
				  dataSrc : ''
				  
			  },
			  columns : [
				  {
					  data : 'id',
				  },
				  {
					data : 'code',
					  mRender : function(data,type,row){
						  
						  return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="adminDataTableImg" />';
					  }
						
				  },
				  {
					  data : 'name'
				  },
				  {
					  data : 'brand'
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
					  data : 'unitPrice',
					  mRender : function(data,type,row){
						  return '&#8377; ' + data
					  }
				  },
				  {
					  data : 'id',
					  bSortable: false,
					  mRender : function(data,type,row){
					  
						  var str = '';
						  str += '<label class="switch">';
						  if(data)
							  {
					              str += '<input type="checkbox" checked="checked" value="'+row.id+'" />'; 
							  } 
						  else
							  {
							      str += '<input type="checkbox"  value="'+row.id+'" />'; 
							  }
						  str += '<div class="slider"></div> </label>';
						  
						  return str;
					  }
					  
				  },
				  {
					  data : 'id',
					  bSortable: false,
					  mRender : function(data,type,row){
						  
						  var str = '';
						  str +='<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-warning"><span class="glyphicon glyphicon-pencil" ></span></a>';
						  
						  return str;
						  
					  }
					  
				  }
				  
				  
			  ],
			  
			  //bootbox code here for activation and deactivation
			  initComplete : function(){
				  
				  var api = this.api();
				  api.$('.switch input[type="checkbox"]').on('change',function(){
						
						var checkbox = $(this);
						var checked = checkbox.prop('checked');
						var dMsg = (checked)? 'You want to activate the product????' : 'You want to deactivate the product???';						
						var value = checkbox.prop('value'); 
						
						bootbox.confirm({						
							size : 'medium', 
							title : 'Product Activation and Deactivation',
							message : dMsg,
							callback : function(confirmed){								
								if(confirmed)
								{								
									console.log(value);
									
									//for activation the toggle
									var activationURl = window.contextRoot + '/manage/product/' + value + '/activation';
									
									$.post(activationURl,function(data)
									{
										bootbox.alert({
											size : 'medium', 
											title : 'information',
											message : data			
										});		
										
									});
											
								  }
								else
									{
									  checkbox.prop('checked',!checked);
									}			
							}
						});
						
					})
				  
			  }
			  
			  
		  });
		
		}

	
	/**************************jquery validation for category********************************************/
	
	var $categoryForm=$('#categoryForm') 
	
	if($categoryForm.length)
		{
		$categoryForm.validate({
			 
			   rules: {
				   
				   name: {
					   
					   required : true,
					   minlength : 2
					   
				   },
				   description : {
					   
					   required : true
				   }
			   },
			  
			   messages : {
				   
				   name : {
					   
					   required : "please enter the category name!",
					   minlength : "category names should not be less than 2!",
					   
				   },
				   description : {
					   
					   required : "please add description for this category!!",
				   }
				   
			   },
			   errorElement : 'em',
			   errorPlacement : function(error,element) {
				   
				   //add the class of help-block
				   error.addClass('help-block');
				   
				   //add the error element after input element
				   error.insertAfter(element);
			   }		   
		   });
		   	
		}
	
	
	//-------------------valiadation for-----LOGIN FORM-----------------------------------------------------
	
var $loginForm=$('#loginForm') 
	
	if($loginForm.length)
		{
		$loginForm.validate({
			 
			   rules: {
				   
				   username: {
					   
					   required : true,
					   email : true
					   
				   },
				   password : {
					   
					   required : true
				   }
			   },
			  
			   messages : {
				   
				   username : {
					   
					   required : "please enter username!",
					   email : "please enter validate email!",
					   
				   },
				   password : {
					   
					   required : "please enter the password!!",
				   }
				   
			   },
			   errorElement : 'em',
			   errorPlacement : function(error,element) {
				   
				   //add the class of help-block
				   error.addClass('help-block');
				   
				   //add the error element after input element
				   error.insertAfter(element);
			   }		   
		   });
		   	
		}
	
	//--------------------------------------------------------------------------------------
	/******************refresh cart*****cartLine Product count using jqery*********************/

    $('button[name="refreshCart"]').click(function(){
    
    	//fetch the cartline id
    	var cartLineId = $(this).attr('value');
    	var countElement = $('#count_' +cartLineId);
    	
    	var originalCount = countElement.attr('value');
    	var currentCount = countElement.val();
    	
    	//work only when the count has changed
    	
    	if(currentCount !== originalCount)
    		{
    		    
    		    if(currentCount < 1 || currentCount >3)
    		    	{
    		    	  
    		    	    //revert back to original count
    		    	countElement.val(originalCount);
    		    	bootbox.alert({
    		    		size: 'medium',
    		    		title: 'error',
    		    		message: 'Product should be min 1 or max 3'
    		    		
    		    	      });
    		    	
    		    	}
    		    else
    		    	{
    		    	  var updateURL = window.contextRoot +'/cart/' +cartLineId+'/update?count='+currentCount;
    		    	  
    		    	  //forward it to the controller
    		    	  window.location.href=updateURL;
    		    	
    		    	}
    		   
    		}
    	
    })
    
    
    








/*************************************************************************/
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
});
