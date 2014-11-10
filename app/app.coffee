angular.module 'devoxx', ['ngAnimate']

.controller 'BasketController', class
  constructor: (@$http)->
    @basket = {}
    @emails = []

  add: (email) ->
    @emails.push email
    @$http.get("/basket?emails=#{@emails}").success (data) =>
      @basket = data









.directive 'score', ->
  scope:
    value: '='
    category: '@'
  templateUrl: '/directives/score.html'
