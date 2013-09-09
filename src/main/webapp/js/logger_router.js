(function () {
  "use strict";
  window.APP = window.APP || {Routers: {}, Collections: {}, Models: {}, Views: {}};
  APP.Routers.LoggerRouter = Backbone.Router.extend({
    routes: {
      "loggers/index": "index"
    },

    initialize: function (options) {
      this.loggers = options.loggers;
      this.index();
    },

    index: function () {
      this.currentView = new APP.Views.LoggerIndexView({loggers: this.loggers});
    },
    
  });
}());
