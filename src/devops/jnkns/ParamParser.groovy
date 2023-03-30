package devops.jnkns

class ParamParser {
    static Map parseParams(def buildParams) {
        Map parsedParams = [:]
        buildParams.each { key, value ->
            parsedParams[key] = value
        }
        return parsedParams
    }
}