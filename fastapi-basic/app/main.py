import uvicorn
from fastapi import FastAPI
from app.router.user import router as user_router
from app.router.order import router as order_router
app = FastAPI()

app.include_router(user_router)
app.include_router(order_router)
if __name__ == "__main__":
    uvicorn.run(
        "main:app",
        port=3000,
        reload=False,
        host="127.0.0.1",
    )