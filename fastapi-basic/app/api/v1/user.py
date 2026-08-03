from fastapi import APIRouter

from app.core.response import Result
from app.schemas.user import User

router = APIRouter(prefix="/user", tags=["user"])

@router.post("/", response_model=Result)
async def get_user(user: User):
    return Result.ok(user, message="success")