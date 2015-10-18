var Ajax = (function () {

    var Method = {
        POST: "post",
        GET: "get",
        PUT: "put",
        DELETE: "delete",
        OPTIONS: "options"
    };

    /**
     * Gets priusAjax request
     * @returns {*}
     */
    function getAjaxRequest() {
        var xhr;
        if (window.XMLHttpRequest) {
            xhr = new XMLHttpRequest();
        } else if (window.ActiveXObject) {
            xhr = new ActiveXObject("Microsoft.XMLHTTP");
        }
        return xhr;
    }

    /**
     * Handles Ajax response
     * @param xhr
     * @param success
     * @param error
     */
    function handleAjaxResponse(xhr, success, error) {
        if (xhr.readyState === 4 && xhr.status === 200) {
            if (success) success(xhr.responseText);
        } else {
            if (error) error(xhr.responseText);
        }
    }

    /**
     * Sends Ajax Request
     * @param method
     * @param url
     * @param data
     * @param success
     * @param error
     */
    function sendAjaxRequest(method, url, data, success, error) {
        var xhr = getAjaxRequest();
        xhr.onreadystatechange = function () {
            handleAjaxResponse(xhr, success, error);
        };
        xhr.open(method, url);
        xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhr.send(data);
    }

    /**
     * Gets Form Data from object
     * @param dataObj
     */
    function getFormData(dataObj) {
        var formData = "";
        for (var key in dataObj) {
            if (dataObj.hasOwnProperty(key)) {
                formData += (key + "=" + dataObj[key] + "&");
            }
        }
        return formData.substr(0, formData.length - 1);
    }

    return {
        get: function (url, data, success, error) {
            sendAjaxRequest(Method.GET, url, data, success, error);
        },
        post: function (url, data, success, error) {
            sendAjaxRequest(Method.POST, url, getFormData(data), success, error);
        },
        put: function (url, data, success, error) {
            sendAjaxRequest(Method.PUT, url, data, success, error);
        },
        delete: function (url, data, success, error) {
            sendAjaxRequest(Method.DELETE, url, data, success, error);
        }
    }
})();