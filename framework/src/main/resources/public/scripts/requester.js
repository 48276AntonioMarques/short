async function serverCall(contractIndex, payload) {
    const response = await fetch('/api/contract/' + contractIndex, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(payload)
    });
    return await response.json();
}