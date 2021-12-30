var cartApp =  angular.module('cartApp', []);

cartApp.controller('cartCtrl',  function ($scope, $http) {
  
  $scope.refreshCart =  function(cartId) {
    $http.get('/WEBZ2/rest/cart/'+$scope.cartId)
    .success(function(data) {
      $scope.cart =  data;
    });
  };
 
  $scope.clearCart =  function() {
    $http.delete('/WEBZ2/rest/cart/'+$scope.cartId)
    .success($scope.refreshCart($scope.cartId));   
  };
  
  $scope.initCartId =  function(cartId) {
    $scope.cartId=cartId;
    $scope.refreshCart($scope.cartId);
  };
 
  $scope.addToCart =  function(productId) {
    $http.put('/WEBZ2/rest/cart/add/'+productId).success(function(data) {
      $scope.refreshCart($http.get('/WEBZ2/rest/cart/get/cartId'));
      alert("Proizvod uspješno dodan u korpu!");
    });
  };
  $scope.removeFromCart =  function(productId) {
    $http.put('/WEBZ2/rest/cart/remove/'+productId).success(function(data) {
      $scope.refreshCart($http.get('/WEBZ2/rest/cart/get/cartId'));
    });
  };
});


