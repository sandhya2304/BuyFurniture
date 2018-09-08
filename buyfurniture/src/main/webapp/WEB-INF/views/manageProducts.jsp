<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div class="container">

	<div class="row">
	
	<!-- for displaying message and vanish after shown -->
	 <c:if test="${not empty message }">
	  
	    <div class="col-xs-12">
	    
	       <div class="alert alert-success alert-dismissible">
	         
	           <button type="button" class="close" data-dismiss="alert">&times;</button>
	           
	            ${message }
	          
	       </div>
	    
	    </div>
	 
	 
	 
	 </c:if>
	  <!-- product table for storing  -->
    
		<div class="col-md-offset-2 col-md-8">

			<div class="panel panel-primary">

				<div class="panel-heading">

					<h4>Product Management!!</h4>

				</div>
				<div class="panel-body">
				
				<!-- form elements -->
				
				<sf:form class="form-horizontal" modelAttribute="product" 
				         action="${contextRoot}/manage/products" 
					     method="POST" 
					     enctype="multipart/form-data"
					     >
					
				
				
				 <div class="form-group">
							<label class="control-label col-md-4">Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" class="form-control"
									placeholder="Product Name" />
								<sf:errors path="name" cssClass="help-block" element="em"/> 
							</div>
						</div>
						
				  
				  <div class="form-group">
							<label class="control-label col-md-4">Brand</label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" class="form-control"
									placeholder="Brand Name" /> 
								<sf:errors path="brand" cssClass="help-block" element="em"/> 
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Description</label>
							<div class="col-md-8">
								<sf:textarea path="description" class="form-control"
									placeholder="Enter your description here!" /> 
								      <sf:errors path="description" cssClass="help-block" element="em"/>                             
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Unit Price</label>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice" class="form-control"
									placeholder="Enter Unit Price" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em"/> 
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Quantity</label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity" class="form-control"
									placeholder="Enter Quantity" />
								      
							</div>
						</div>
						
						<!-- file elemnet for image -->
						
						<div class="form-group">
							<label class="control-label col-md-4">Select an Image:</label>
							<div class="col-md-8">
								<sf:input type="file" path="file" class="form-control" />
								 <sf:errors path="file" cssClass="help-block" element="em" />     
							</div>
						</div>



						<div class="form-group">
							<label class="control-label col-md-4">Category</label>
							<div class="col-md-8">
								<sf:select path="categoryId" 
								           items="${categories}" 
								           itemLabel="name" 
								           itemValue="id" class="form-control" id="categoryId"/>
													
							</div>
							
						</div>


					
						<div class="form-group">
							
							<div class="col-md-offset-4 col-md-4">
							
										
							<!-- hidden fields for getting original values -->			
									<sf:hidden path="id"/>
									<sf:hidden path="code"/>
									<sf:hidden path="supplierId"/>
									<sf:hidden path="active"/>		
									<sf:hidden path="purchases"/>	
									<sf:hidden path="views"/>	
							<!-- hidden fields for getting original values -->	
							
								<input type="submit" name="submit" value="Save" class="btn btn-primary"/>
								
							</div>
						</div>	
				
				</sf:form>
				
				
	 
                </div> 
          
         </div>
        
      </div>
      
    </div>
  
<!-- admin Product table -->

<div class="row">

   <div class="col-xs-12">
   
     <h3>Available Products</h3>
     <hr/>
   </div>
   
    <div class="col-xs-12">
      <div style="overflow:auto">
      
       <table id="productsTable" class="table table-condensed table-bordered">
							
				<thead>					
					<tr>					
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>Brand</th>
						<th>Qty. Avail</th>
						<th>Unit Price</th>
						<th>Activate</th>				
						<th>Edit</th>
					</tr>					
				</thead>
				
				<tbody>
				
				  <tr> 
				    <td>3</td>
				    <td>  
				    
				      <img class="adminDataTableImg" alt="Google Pixel" src="${contextRoot}/resources/images/PRDPQR123WGTX.jpg">
				     
				    </td>
				    <td>Google  </td>
				    <td>Google Pixel </td>
				    <td>5</td>
				    <td>&#8377; 57000 /- </td>
				    <td>
				    <!-- toggle switch -->
				     <label class="switch">
				        <input type="checkbox" checked="checked" value="3" />
				        <div class="slider" ></div>
				     </label>  </td>
				     <td>
				     
				       <a href="${contextRoot}/manage/3/product" class="btn btn-warning" ><span class="glyphicon glyphicon-pencil" ></span>   </a>
				     
				     </td>
				  </tr>
				  
				   <tr> 
				    <td>3</td>
				    <td>  
				    
				      <img class="adminDataTableImg" alt="Google Pixel" src="${contextRoot}/resources/images/PRDPQR123WGTX.jpg">
				     
				    </td>
				    <td>Google  </td>
				    <td>Google Pixel </td>
				    <td>5</td>
				    <td>&#8377; 57000 /- </td>
				    <td>
				    <!-- toggle switch -->
				     <label class="switch">
				        <input type="checkbox" checked="checked" value="3" />
				         <input type="checkbox"  value="3" />
				        <div class="slider"></div>
				     </label>  </td>
				     <td>
				     
				       <a href="${contextRoot}/manage/3/product" class="btn btn-warning" ><span class="glyphicon glyphicon-pencil" ></span>   </a>
				     
				     </td>
				  </tr>
				
				</tbody>
				
				<tfoot>
					<tr>					
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>Brand</th>
						<th>Qty. Avail</th>
						<th>Unit Price</th>
						<th>Activate</th>				
						<th>Edit</th>
					</tr>									
				</tfoot>
				
							
			</table>
      
      
      </div>
   
   
   </div>
   


</div>


</div>