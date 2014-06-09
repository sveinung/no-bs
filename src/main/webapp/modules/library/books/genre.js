define(function(require) {

    var BaseModel = require('base/model');

    var Genre = BaseModel.extend({
        default: {
            name: null
        }
    });

    return Genre;
});
