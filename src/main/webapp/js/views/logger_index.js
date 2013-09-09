(function () {
  "use strict";
  window.APP = window.APP || {Routers: {}, Collections: {}, Models: {}, Views: {}};
  APP.Views.LoggerIndexView = Backbone.View.extend({

    initialize: function (options) {
      this.loggers = options.loggers;
      this.loggers.on("sync",this.onFetched,this);
      this.loggers.fetch();

    },
    
    onFetched: function() {
        $('#content').html(this.render().el);
    },

    render: function () {
      this.$el.html($('#indexTemplate').html());
      this.addAll();
      return this;
    },

    addAll: function () {
      // clear out the container each time you render index
      this.$el.find('tbody').children().remove();
      _.each(this.loggers.models, $.proxy(this, 'addOne'));
    },

    addOne: function (logger) {
      var view = new APP.Views.LoggerRowView({logger: logger});
      this.$el.find("tbody").append(view.render().el);
    }
  });
}());
