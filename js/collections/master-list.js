(function () {
    'use strict';
    var NewMasterListItem = require('../models/master-list-item');
    var BaseList = require('./base-list');
    var env = require('../env');
    module.exports = BaseList.extend({
        model: NewMasterListItem,
        url: env.API_BASE + '/master-list',

        clearSelection: function () {
            this.each(function (model) {
                model.set('selected', false);
            });
        }
    });
})();