(function () {

	APP.Models.Loggers = Backbone.Collection.extend({

        url: "/rest/logconfig/list",
        model: APP.Models.Logger,

        comparator: function (logger) {
            return logger.getName();
        }

    });

})();