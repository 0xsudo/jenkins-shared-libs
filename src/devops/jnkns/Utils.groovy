package src.devops.jnkns

class Utils {
    static Map parseParams(def context, Map params = [:]) {
        context.request.parameterNames.each { paramName ->
            params[paramName] = context.request.getParameter(paramName)
        }
        return params
    }
}