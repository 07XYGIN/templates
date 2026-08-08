from fastapi import APIRouter,Depends
import logging
from app.core.response import Result
from app.schemas.user import User
from app.utlis.use_redis import redis_set,redis_exists
from sqlalchemy.ext.asyncio import AsyncSession

router = APIRouter(prefix="/user", tags=["user"])

@router.post("/register")
async def register(user_info:User,db: AsyncSession = Depends(get_db))