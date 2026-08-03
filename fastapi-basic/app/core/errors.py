from fastapi import Request
from fastapi.exceptions import RequestValidationError
from fastapi.responses import JSONResponse


class ParameterException(Exception):
    def __init__(self, message: str, code: int = 400):
        self.message = message
        self.code = code


async def parameter_exception_handler(request: Request, exc: ParameterException):
    return JSONResponse(
        status_code=exc.code,
        content={"code": exc.code, "message": exc.message},
    )


async def validation_exception_handler(request: Request, exc: RequestValidationError):
    return JSONResponse(
        status_code=422,
        content={
            "code": 422,
            "message": "不合法的参数",
            "detail": exc.errors(),
        },
    )


exception_handlers = [
    (ParameterException, parameter_exception_handler),
    (RequestValidationError, validation_exception_handler),
]