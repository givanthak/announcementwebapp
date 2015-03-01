var helloApp = angular.module("announcementApp", [ 'ngResource' ]);

function PeopleCtrl($scope, $http) {
	$scope.announcements = [];

	$scope.loadAnnouncements = function() {
		alert("start");

		$scope.getAnnouncements = function($scope, $http) {
			$http({
				method : 'GET',
				url : '/announcement-web/api/announcements'
			}).success(function(data, status, headers, config) {
				alert(data);
				$scope.announcements = data;
			}).error(function(data, status, headers, config) {
				alert("failure");
			});

		};
	};

}


// announcemenApp.controller("AnnouncementCtrl", ['$scope', '$http',
// function($scope, $http) {
// alert("start");
// $scope.announcements = [];
//	
// $scope.getAnnouncements = function($scope, $http) {
// $http({
// method : 'GET',
// url : '/announcement-web/api/announcements'
// }).success(function(data, status, headers, config) {
// alert(data);
// $scope.announcements = data;
// }).error(function(data, status, headers, config) {
// alert( "failure");
// });
// };
//	    

// $scope.addRowAsyncAsJSON = function(){
//		
// $scope.companies.push({ 'name':$scope.name, 'employees': $scope.employees,
// 'headoffice':$scope.headoffice });
// // Writing it to the server
// //
// var dataObj = {
// name : $scope.name,
// employees : $scope.employees,
// headoffice : $scope.headoffice
// };
// var res = $http.post('/savecompany_json', dataObj);
// res.success(function(data, status, headers, config) {
// $scope.message = data;
// });
// res.error(function(data, status, headers, config) {
// alert( "failure message: " + JSON.stringify({data: data}));
// });
// // Making the fields empty
// //
// $scope.name='';
// $scope.employees='';
// $scope.headoffice='';
// };
