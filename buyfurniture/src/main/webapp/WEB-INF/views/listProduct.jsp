<div class="container">

   
    <div class="row">
     
       <!-- would be to display container -->
      <div class="col-md-3">
      
        <%@include file="./shared/sidebar.jsp" %>
      
      </div>
      
      <!-- would be to display actual products -->
      <div class="col-md-9">
      
      <!-- added breadcrumg compnent -->
        <div class="row">
        
          <div class="col-lg-12">
            
            <c:if test="${userClickAllProducts == true }">
             <ol class="breadcrumb">
               
                <li><a href="${contextRoot}/home">Home</a> </li>
                 <li class="active">List All Products </li>
             
             </ol>
             </c:if>
             
               
            <c:if test="${userClickCategoryProducts == true }">
             <ol class="breadcrumb">
               
                <li><a href="${contextRoot}/home">Home</a> </li>
                 <li class="active"> Category </li>
                  <li class="active"> ${category} </li>
             
             </ol>
             </c:if>
          
          </div>
        
        
        </div>
        
      
      
      </div>
    
    
    
    </div>





</div>