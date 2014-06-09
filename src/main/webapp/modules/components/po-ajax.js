define(function(require) {

    var sinon = require('sinon');

    return {
        mockRequest: function(callback, context) {
            var server = sinon.fakeServer.create();

            callback.call(context || this);

            this.lastRequestBody = server.queue[0].requestBody;

            server.respond();
            server.restore();

            return this;
        },
        expectToHaveSaved: function(attributes) {
            var requestBody = JSON.parse(this.lastRequestBody);
            var obj = _.pick(requestBody, _.keys(attributes));

            expect(obj).toEqual(attributes);

            return this;
        }
    }

});