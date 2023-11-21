const base_path = 'http://192.168.188.167:8080/complejo'

export default async () => {
    try {
        const response = await fetch(`${base_path}`, {
            headers: {
                "Authorization": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzZWJhc3VyYmluQGdtYWlsLmNvbSIsImlhdCI6MTcwMDEzMjA0MywiZXhwIjoxNzAwMTMzNDgzfQ.yWo5bbywBb8_Yq4pIo5IN9DWfXMT9gB3ki1RBAa37ZXV3KRJKUF6iEwTLPmPfQssHgo6EAvAP4s3hzpjUghzbw"
            }
        });

        const data = await response.json()

        return Promise.resolve(data);
    } catch(err) {
        console.error("fetch error", err);
        return Promise.reject(err);
    }
}