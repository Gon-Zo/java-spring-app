export const getNowUrl = () => {
    const href = window.location.href
    const urlArray = href.split("#")
    const nowUrl = urlArray[1]
    return nowUrl
}
