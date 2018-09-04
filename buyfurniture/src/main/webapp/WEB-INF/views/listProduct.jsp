<div class="container">


	<div class="row">

		<!-- would be to display container -->
		<div class="col-md-3">

			<%@include file="./shared/sidebar.jsp"%>

		</div>

		<!-- would be to display actual products -->
		<div class="col-md-9">

			<!-- added breadcrumb component -->
			<div class="row">

				<div class="col-lg-12">

					<c:if test="${userClickAllProducts == true }">

						<!-- for all products -->
						<script>
							window.categoryId = '';
						</script>


						<ol class="breadcrumb">

							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">List All Products</li>

						</ol>
					</c:if>

					<!-- for particular cateogry -->
					<c:if test="${userClickCategoryProducts == true }">

						<script>
							window.categoryId = '${category.id}';
						</script>



						<ol class="breadcrumb">

							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>

						</ol>
					</c:if>

				</div>


			</div>

			<div class="row">

				<div class="col-xs-12">

					<table id="productListTable"
						class="table table-striped table-bordered">

						<thead>

							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price:</th>
								<th>Quantity Available</th>
								<th></th>
							</tr>

						</thead>

						<tfoot>

							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price:</th>
								<th>Quantity Available</th>
								<th></th>

							</tr>

						</tfoot>

					</table>

				</div>

			</div>

		</div>



	</div>





</div>